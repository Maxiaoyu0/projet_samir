package fr.polytech.projet_samir.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: M. Maxiaoyu
 * @create: 2019-01-19 18:10
 **/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "bookEntityManagerFactory",
        basePackages= {"fr.polytech.projet_samir.bookDao"},transactionManagerRef = "bookTransctionManager")

public class BookDBConfig {

    @Bean(name = "bookDatasource")
    @ConfigurationProperties(prefix = "spring.book.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("bookEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
                                                                           @Qualifier("bookDatasource") DataSource dataSource){
//        Map<String,Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto","update");
//        properties.put("hibernate.dialect","org.hibernate.dialect.MYSQL8Dialect");
        return builder
                .dataSource(dataSource)
                //.properties(properties)
                .packages("fr.polytech.projet_samir.book")
                .persistenceUnit("Book").build();

    }
    @Bean(name = "bookTransctionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("bookEntityManagerFactory") EntityManagerFactory entityManagerFactory){
        return  new JpaTransactionManager(entityManagerFactory);
    }
}
