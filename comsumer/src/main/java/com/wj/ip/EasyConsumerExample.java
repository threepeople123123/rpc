package com.wj.ip;


import com.wj.ip.model.User;
import com.wj.ip.proxy.ServiceProxyFactory;
import com.wj.ip.service.UserService;

/**
 * 简易服务消费者示例
 */
public class EasyConsumerExample {

    public static void main(String[] args) {
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);

        User user = new User();
        user.setName("yupi");
        // 调用
        User newUser = userService.getUser(user);
        short result =  userService.getNumber();
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
