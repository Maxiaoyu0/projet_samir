package fr.polytech.projet_samir.config;

//import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
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




import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: M. Maxiaoyu
 * @create: 2019-01-19 16:36
 **/
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef =  "entityManagerFactory1",
        basePackages= {"fr.polytech.projet_samir.userDao"},transactionManagerRef = "transctionManager")
public class UserDBConfig {
    @Primary
    @Bean(name = "datasource")
    @ConfigurationProperties(prefix = "spring.user.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean("entityManagerFactory1")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder, @Qualifier("datasource") DataSource dataSource){
//        Map<String,Object> properties = new HashMap<>();
//        properties.put("hibernate.hbm2ddl.auto","update");
//        properties.put("hibernate.dialect","org.hibernate.dialect.MYSQL5Dialect");
        return builder
                .dataSource(dataSource)
                //.properties(properties)
                .packages("fr.polytech.projet_samir.user")
                .persistenceUnit("User").build();

    }
    @Primary
    @Bean(name = "transctionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory1") EntityManagerFactory entityManagerFactory){
        return  new JpaTransactionManager(entityManagerFactory);
    }
}
