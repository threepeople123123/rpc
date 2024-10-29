package com.wj.ip.serviceImpl;


import com.wj.ip.RpcApplication;
import com.wj.ip.registry.LocalRegistry;
import com.wj.ip.server.HttpServer;
import com.wj.ip.server.VertxHttpServer;
import com.wj.ip.service.UserService;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // 初始化rpc框架,也可以需要时，调用rpc.getRpcConfig()方法获取，使用double check lock 进行控制对象只会初始化一次
        RpcApplication.init();

        // 注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);

        // 提供服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
