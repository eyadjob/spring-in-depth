package com.spring.in.depth.mastering.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "EjarStgEntityManagerFactory",
        transactionManagerRef = "EjarStgTransactionManager",
        basePackages = {"com.spring.in.depth.mastering.repository.ejar.stg"})
@PropertySource("application.properties")
public class SqlConfig {

    @Primary
    @Bean(name = "EjarStgDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ejar.stg")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "EjarStgEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
            EntityManagerFactoryBuilder builder
    ) {
        return builder
                .dataSource(dataSource())
                .packages("com.spring.in.depth.mastering.entity.ejar.stg")
                .persistenceUnit("EjarStgPU")
                .build();
    }

    @Primary
    @Bean(name = "EjarStgTransactionManager")

    public PlatformTransactionManager transactionManager(
            @Qualifier("EjarStgEntityManagerFactory") EntityManagerFactory
                    entityManagerFactory
    ) {
        return new JpaTransactionManager(entityManagerFactory);
    }


}
