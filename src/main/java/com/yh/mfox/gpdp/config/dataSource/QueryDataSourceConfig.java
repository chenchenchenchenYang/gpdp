package com.yh.mfox.gpdp.config.dataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 查询数据源
 */
@Configuration
@MapperScan(basePackages = "com.yh.mfox.gpdp.mapper.query", sqlSessionFactoryRef = "querySqlSessionFactory")
public class QueryDataSourceConfig {
    @Bean("queryDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.query")
    public DataSource getDb1DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("querySqlSessionFactory")
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("queryDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/mapper/query/*.xml"));
        return bean.getObject();
    }

    @Bean("querySqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("querySqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
