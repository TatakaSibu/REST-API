package com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class JpaConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        // Set packages to scan for entity classes
        em.setPackagesToScan("com.enviro.assessment.grad001.teboho.nyombolo.REST.API.Enviro365.Model");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }
}
