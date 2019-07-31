package com.mtl.client;

import com.mtl.model.UserModel;
import com.mtl.server.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author mtl
 * @Description: Spring结合Dubbo客户端案例
 * @date 2019/7/31 21:35
 */
public class SpringDubboClient {
    /**
     * 通过Spring获取客户端调用
     * @return
     */
    public UserService getUserService(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring-consumer.xml");
        UserService userService = context.getBean(UserService.class);
        return userService;
    }

    public static void main(String[] args) {
        UserService userService = new SpringDubboClient().getUserService();
        UserModel userInfo = userService.getUserInfo(111);
        System.out.println("远程调用获取用户信息成功");
        System.out.println(userInfo);
    }
}
