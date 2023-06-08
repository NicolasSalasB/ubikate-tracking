package com.example.ubikatetracking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.url}")
    private String defaultUrl;

    @Value("${spring.datasource.username}")
    private String defaultUsername;

    @Value("${spring.datasource.password}")
    private String defaultPassword;

    @Value("${tenant.datasource.url}")
    private String tenantUrl;

    @Value("${tenant.datasource.username}")
    private String tenantUsername;

    @Value("${tenant.datasource.password}")
    private String tenantPassword;

    @Bean
    public DataSource defaultDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(defaultUrl);
        dataSource.setUsername(defaultUsername);
        dataSource.setPassword(defaultPassword);
        return dataSource;
    }

    @Bean
    public DataSource tenantDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(tenantUrl);
        dataSource.setUsername(tenantUsername);
        dataSource.setPassword(tenantPassword);
        return dataSource;
    }

    @Bean
    @Primary
    public DataSourceRouting dataSource() {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("default", defaultDataSource());
        targetDataSources.put("tenant", tenantDataSource());

        DataSourceRouting dataSourceRouting = new DataSourceRouting();
        dataSourceRouting.setDefaultTargetDataSource(defaultDataSource());
        dataSourceRouting.setTargetDataSources(targetDataSources);
        return dataSourceRouting;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("com.example.ubikatetracking.model");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        // Configuración adicional de Hibernate, si es necesaria
        emf.setJpaProperties(properties);

        return emf;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }
}
