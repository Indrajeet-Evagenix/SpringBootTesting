package com.springboot.crud.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class MultipleDBConfig {

    @Bean(name = "kuberDbProperties")
    @ConfigurationProperties("spring.dsprimary")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }
    //step 2
    @Primary
    @Bean(name = "kuberDbDataSource")
//    @ConfigurationProperties(prefix = "spring.kuberdb.hikari")
    public DataSource dataSource(@Qualifier("kuberDbProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }
    //step 3
    @Bean("kuberDb")
    public JdbcTemplate jdbcTemplate(@Qualifier("kuberDbDataSource") DataSource ccbsDataSource) {
        return new JdbcTemplate(ccbsDataSource);
    }

    //step 3.1
    /*@Primary
    @Bean("namekuberDb")
    public NamedParameterJdbcTemplate parameterJdbcTemplate(@Qualifier("kuberDbDataSource") DataSource ccbsDataSource) {
        return new NamedParameterJdbcTemplate(ccbsDataSource);
    }*/
}
