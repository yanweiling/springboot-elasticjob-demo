package com.ywl.study.config.esjob;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class ElasticJobDatabase  {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.elasticjob")
    public DataSource elasticjobDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory elasticjobSqlSessionFactory(@Qualifier("elasticjobDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean
    public DataSourceTransactionManager elasticjobTransactionManager(@Qualifier("elasticjobDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate elasticjobSqlSessionTemplate(@Qualifier("elasticjobSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
