package com.wj.ip;

import com.wj.ip.config.RegistryConfig;
import com.wj.ip.config.RpcConfig;
import com.wj.ip.constant.RpcConstant;
import com.wj.ip.registry.Registry;
import com.wj.ip.registry.RegistryFactory;
import com.wj.ip.util.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * RPC 框架应用
 * 相当于 holder，存放了项目全局用到的变量。双检锁单例模式实现
 */
@Slf4j
public class RpcApplication {

    private static volatile RpcConfig rpcConfig;

    /**
     * 框架初始化，支持传入自定义配置
     *
     * @param newRpcConfig
     */
    /*public static void init(RpcConfig newRpcConfig) {
        rpcConfig = newRpcConfig;
        log.info("rpc init, config = {}", newRpcConfig.toString());
    }
*/

    /**
     * 框架初始化，支持传入自定义配置
     *
     * @param newRpcConfig 配置文件
     */
    public static void init(RpcConfig newRpcConfig) {
        rpcConfig = newRpcConfig;
        log.info("rpc init, config = {}", newRpcConfig.toString());
        // 注册中心初始化
        RegistryConfig registryConfig = rpcConfig.getRegistryConfig();
        Registry registry = RegistryFactory.getInstance(registryConfig.getRegistry());
        registry.init(registryConfig);
        log.info("registry init, config = {}", registryConfig);
    }


    /**
     * 初始化
     */
    public static void init() {

        RpcConfig newRpcConfig;
        try {
            // 读取配置文件，设置前缀
            newRpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.WJ_CONFIG_PREFIX);
        } catch (Exception e) {
            // 配置加载失败，使用默认值
            newRpcConfig = new RpcConfig();
        }
        init(newRpcConfig);
    }

    /**
     * 获取配置
     *
     * @return
     */
    public static RpcConfig getRpcConfig() {
        if (rpcConfig == null) {
            synchronized (RpcApplication.class) {
                if (rpcConfig == null) {
                    init();
                }
            }
        }
        return rpcConfig;
    }

}
