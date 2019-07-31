package com.mtl.server;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;

import java.io.IOException;

/**
 * @author mtl
 * @Description: 原生Dubbo服务端案例
 * @date 2019/7/31 18:55
 */
public class ProtoDubboServer {
    /**
     * 开启服务
     * @param port
     */
    public void openServer(int port) {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("simple-app");
        ProtocolConfig protocolConfig=new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(port);
        protocolConfig.setThreads(20);
        ServiceConfig<UserService> serviceConfig=new ServiceConfig();
        serviceConfig.setApplication(config);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setRegistry(new RegistryConfig(RegistryConfig.NO_AVAILABLE));
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(new UserServiceImpl());
        serviceConfig.export();
    }

    /**
     * 开启服务
     * @param multiaddress
     */
    public void openMultiServer(String multiaddress) {
        ApplicationConfig config = new ApplicationConfig();
        config.setName("simple-app");
        ProtocolConfig protocolConfig=new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setThreads(20);
        ServiceConfig<UserService> serviceConfig=new ServiceConfig();
        serviceConfig.setApplication(config);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setRegistry(new RegistryConfig(multiaddress));
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(new UserServiceImpl());
        serviceConfig.export();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
//        new ProtoDubboServer().openServer(12345);
        new ProtoDubboServer().openMultiServer("multicast://224.1.1.1:2222");
        System.in.read();
    }
}
