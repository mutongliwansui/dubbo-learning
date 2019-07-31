package com.mtl.server;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author mtl
 * @Description: Spring结合Dubbo服务端
 * @date 2019/7/31 21:31
 */
public class SpringDubboServer {
    /**
     * 读取Spring配置文件，初始化Server服务
     * @throws IOException
     */
    public void initServer() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-provide.xml");
        ((ClassPathXmlApplicationContext) context).start();
    }

    public static void main(String[] args) throws IOException {
        new SpringDubboServer().initServer();
        System.in.read();
    }
}
