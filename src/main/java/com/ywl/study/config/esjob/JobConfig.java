package com.ywl.study.config.esjob;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.ywl.study.taskjob.simplejob.SimpleJobDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 全局作业配置中心类
 */
@Configuration
public class JobConfig {
    @Autowired
    private ZookeeperRegistryCenter regCenter;

    @Autowired
    private LiteJobConfiguration liteJobConfiguration;
    @Autowired
    private JobEventConfiguration jobEventConfiguration;
    @Autowired
    private SimpleJobDemo simpleJobDemo;
    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(){
        return new SpringJobScheduler(simpleJobDemo,regCenter,liteJobConfiguration,jobEventConfiguration);
    }
}
