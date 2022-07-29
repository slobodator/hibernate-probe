package com.sloboda.hibernateprobe;

import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableTransactionManagement
@EnableJpaRepositories
@EnableAsync
public class Application {
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource actualDataSource() {
        return DataSourceBuilder.create()
                .build();
    }

    @Primary
    @Bean
    public DataSource proxyDataSource() {
        return ProxyDataSourceBuilder
                .create(actualDataSource())
                .logQueryBySlf4j()
                .countQuery()
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
