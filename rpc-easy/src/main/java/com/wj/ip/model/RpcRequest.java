package com.wj.ip.model;

import lombok.*;

import java.io.Serializable;

/**
 * RPC 请求
 */
@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RpcRequest implements Serializable {

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 参数类型列表
     */
    private Class<?>[] parameterTypes;

    /**
     * 参数列表
     */
    private Object[] args;

}
