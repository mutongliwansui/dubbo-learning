package com.mtl.client;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.mtl.model.UserModel;
import com.mtl.server.UserService;

/**
 * @author mtl
 * @Description: 原生Dubbo客户端案例
 * @date 2019/7/31 18:41
 */
public class ProtoDubboClient {
    static String remoteUrl = "dubbo://127.0.0.1:12345/com.mtl.server.UserService";
    // 构建远程服务对象
    public UserService buildRemoteService(String remoteUrl) {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("young-app");
        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig();
        referenceConfig.setApplication(application);
        referenceConfig.setInterface(UserService.class);
        referenceConfig.setUrl(remoteUrl);
        UserService userService = referenceConfig.get();
        return userService;
    }

    // 构建远程服务对象
    public UserService buildMultiRemoteService(String multiaddress) {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("young-app");
        ReferenceConfig<UserService> referenceConfig = new ReferenceConfig();
        referenceConfig.setApplication(application);
        referenceConfig.setInterface(UserService.class);
        referenceConfig.setRegistry(new RegistryConfig(multiaddress)); //设置注册中心multi
        UserService userService = referenceConfig.get();
        return userService;
    }



    public static void main(String[] args) {
//        UserService userService = new ProtoDubboClient().buildRemoteService(remoteUrl);
        UserService userService = new ProtoDubboClient().buildMultiRemoteService("multicast://224.1.1.1:2222");
        UserModel userInfo = userService.getUserInfo(111);
        System.out.println("远程调用获取用户信息成功");
        System.out.println(userInfo);
    }
}
