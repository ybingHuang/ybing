//package com.ybing.authentication.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by niko on 2019/5/15.
// */
//@Configuration
//@EnableTransactionManagement
//public class YbingJpaConfig {
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public EntityManagerFactory entityManagerFactory() {
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setShowSql(true);
//
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//        factoryBean.setDataSource(dataSource);
//        factoryBean.setJpaVendorAdapter(adapter);
//        Map<String, Object> jpaProperties = new HashMap();
//        jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
//        jpaProperties.put("hibernate.jdbc.batch_size", 50);
//        factoryBean.setJpaPropertyMap(jpaProperties);
//        factoryBean.setPackagesToScan("com.ybing.authentication.entity");
//        factoryBean.afterPropertiesSet();
//        return factoryBean.getObject();
//    }
//
//    @Bean("transactionManager")
//    public PlatformTransactionManager platformTransactionManager() {
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory());
//        return jpaTransactionManager;
//    }
//}
