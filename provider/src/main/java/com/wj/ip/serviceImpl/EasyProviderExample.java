package com.wj.ip.serviceImpl;


import com.wj.ip.registry.LocalRegistry;
import com.wj.ip.server.HttpServer;
import com.wj.ip.server.VertxHttpServer;
import com.wj.ip.service.UserService;

/**
 * 简易服务提供者示例
 */
public class EasyProviderExample {

    public static void main(String[] args) {

        // 注册服务
        LocalRegistry.register(UserService.class.getName(),UserServiceImpl.class);

        // 提供服务
        HttpServer httpServer = new VertxHttpServer();
        httpServer.doStart(8080);
    }
}
