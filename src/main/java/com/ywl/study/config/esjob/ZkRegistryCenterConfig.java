package com.ywl.study.config.esjob;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  Zk注册中心配置类
 */
@Configuration
public class ZkRegistryCenterConfig {
    @Value("${reg-center.server-list}")
    private String serverList;

    @Value("${reg-center.namespace}")
    private String namespace;

    /**
     * 实例化zookeeper注册中心实例后，执行init方法，否则不生效
     * @return
     */
    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter regCenter(){
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList,namespace));
    }




}
