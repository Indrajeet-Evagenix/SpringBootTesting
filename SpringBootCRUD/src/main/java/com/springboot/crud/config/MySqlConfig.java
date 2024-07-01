package com.springboot.crud.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class MySqlConfig {

    @Bean(name = "kuberDbProperties1")
    @ConfigurationProperties("spring.dssecondary")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }
    //step 2
    @Primary
    @Bean(name = "kuberDbDataSource1")
//    @ConfigurationProperties(prefix = "spring.kuberdb.hikari")
    public DataSource dataSource(@Qualifier("kuberDbProperties1") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
    //step 3
    @Bean("kuberDb1")
    public JdbcTemplate jdbcTemplate(@Qualifier("kuberDbDataSource1") DataSource ccbsDataSource) {
        return new JdbcTemplate(ccbsDataSource);
    }
}
