package com.wj.ip;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.wj.ip.model.RpcRequest;
import com.wj.ip.model.RpcResponse;
import com.wj.ip.model.User;
import com.wj.ip.serializer.JdkSerializer;
import com.wj.ip.serializer.Serializer;
import com.wj.ip.serializer.SerializerFactory;
import com.wj.ip.service.UserService;

import java.io.IOException;

/**
 * 静态代理
 */
public class UserServiceProxy implements UserService {

    @Override
    public User getUser(User user) {
        // 指定序列化器
        Serializer serializer = new JdkSerializer();

        // 发请求
        RpcRequest rpcRequest = RpcRequest.builder()
                .serviceName(UserService.class.getName())
                .methodName("getUser")
                .parameterTypes(new Class[]{User.class})
                .args(new Object[]{user})
                .build();
        try {
            Serializer instance = SerializerFactory.getInstance(RpcApplication.getRpcConfig().getSerializer());
            byte[] bodyBytes =  instance.serialize(rpcRequest);
            byte[] result;
            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8080")
                    .body(bodyBytes)
                    .execute()) {
                result = httpResponse.bodyBytes();
            }
            RpcResponse rpcResponse = instance.deserialize(result, RpcResponse.class);
            return (User) rpcResponse.getData();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
