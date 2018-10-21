package com.daniel.api;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("com.daniel.api")
@EnableJpaRepositories(basePackages = "com.daniel.api.repo") 
public class Config implements WebMvcConfigurer {
	
	@Bean
	public DataSource h2TestDataSource(){
	   return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).build();
	}
	
	@Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, 
                                                                Environment env) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.daniel.api.entities");
 
        Properties jpaProperties = new Properties();

        jpaProperties.put( "hibernate.dialect" , "org.hibernate.dialect.H2Dialect");
        jpaProperties.put( "hibernate.hbm2ddl.auto" , "create-drop");
        jpaProperties.put( "hibernate.show_sql" , true );
 
        entityManagerFactoryBean.setJpaProperties(jpaProperties);
 
        return entityManagerFactoryBean;
    }
	
	@Bean
    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
