package com.example.ecommerce.shared.configuration;

import org.flywaydb.core.Flyway;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.File;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);

        return transactionManager;
    }

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.example.ecommerce");
        factoryBean.setHibernateProperties(hibernateProperties());
        List<Resource> mappingLocations = searchMappingLocations();
        factoryBean.setMappingLocations(mappingLocations.toArray(new Resource[mappingLocations.size()]));
        try {
            factoryBean.afterPropertiesSet();
        } catch (Exception e) {
            throw new RuntimeException("Error setting up SessionFactory", e);
        }
        return factoryBean.getObject();
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        DataSource dataSource = dataSource();
        return Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:db/migration")
                .load();
    }

    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5431/postgres?currentSchema=ecommerce");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        dataSource.setSchema("ecommerce");
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "none");

        return properties;
    }

    private List<Resource> searchMappingLocations() {
        List<String> paths = Arrays.stream(new File(Paths.get("").toAbsolutePath().toString() + "/src/main/java/com/example/ecommerce")
                        .list((path, name) -> new File(path, name).isDirectory()))
                .map(entry -> Paths.get("").toAbsolutePath().toString() + "/src/main/java/com/example/ecommerce/" + entry + "/infrastructure/persistance/hibernate")
                .filter(path -> new File(path).isDirectory())
                .collect(Collectors.toList());
        List<Resource> resources = new ArrayList<>();
        for(String path : paths) {
            resources.addAll(Arrays.stream(new File(path).list((file, name) -> new File(file, name).getName().contains(".hbm.xml")))
                    .map(file -> new FileSystemResource(path + "/" + file))
                    .collect(Collectors.toList()));
        }
        return resources;
    }

}
