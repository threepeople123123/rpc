package com.wj.ip.proxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class MockServiceHandler implements InvocationHandler{


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Class<?> returnType = method.getReturnType();

        log.info("mock 数据，需要的类型为:{}",returnType.getName());
        return getAllClassType(returnType);
    }

    // 需要什么类型，给出什么类型的数据
    public Object getAllClassType(Class<?> par){
        if (par.isPrimitive()){
            if (par == boolean.class){
                return  false;
            }
            else if (par == short.class){
                return  (short)0;
            }
            else if (par == int.class){
                return  0;
            }
            else if (par == double.class){
                return  0.0;
            }
            else if (par == float.class){
                return  0.0;
            }
            else if (par == char.class){
                return  0;
            }
            else if (par == long.class){
                return  0L;
            }
            else if (par == String.class){
                return  "";
            }
        }
        return null;
    }

}
