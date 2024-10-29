package com.wj.ip;

import com.wj.ip.config.RpcConfig;
import com.wj.ip.model.User;
import com.wj.ip.proxy.ServiceProxyFactory;
import com.wj.ip.service.UserService;
import com.wj.ip.util.ConfigUtils;

/**
 * 简易服务消费者示例
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @learn <a href="https://codefather.cn">编程宝典</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
public class ConsumerExample {

    public static void main(String[] args) {

        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("wj");

        // 获取对象
        User newUser = userService.getUser(user);


        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "wj");
        System.out.println(rpc);
    }
}
