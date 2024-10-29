package com.wj.ip.proxy;

import com.wj.ip.RpcApplication;
import java.lang.reflect.Proxy;

/**
 * 服务代理工厂（用于创建代理对象）
 */
public class ServiceProxyFactory {

    /**
     * 根据服务类获取代理对象
     *
     * @param serviceClass
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Class<T> serviceClass) {

        // 如果开启了mock数据，直接返回mock的数据
        if (RpcApplication.getRpcConfig().isMock()){
            return getMockProxy(serviceClass);
        }

        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy());
    }

    private static <T> T getMockProxy(Class<T> data){
        return (T) Proxy.newProxyInstance(data.getClassLoader(),new Class[]{data},new MockServiceHandler());
    }
}
