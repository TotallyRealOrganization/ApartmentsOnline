package com.apartmentsOnline.tests.DAO;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com.apartmentsonline")
@EnableTransactionManagement
public class TestConfig {
    @Value("org.postgresql.Driver")
    private String driver;
    @Value("jdbc:postgresql://database-3.co7alrlvzgzk.us-west-2.rds.amazonaws.com:5432/postgres")
    private String url;
    @Value("postgres")
    private String username;
    @Value("password")
    private String password;
    @Value("org.hibernate.dialect.PostgreSQL9Dialect")
    private String dialect;

    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactoryBean(DataSource ds) {
        LocalSessionFactoryBean sfBean = new LocalSessionFactoryBean();
        sfBean.setDataSource(ds);
        sfBean.setPackagesToScan("com.apartmentsonline.models");
        sfBean.setHibernateProperties(getProps());
        return sfBean;
    }

    @Bean
    HibernateTransactionManager hibernateTransactionManager(SessionFactory sf) {
        HibernateTransactionManager manager = new HibernateTransactionManager();
        manager.setSessionFactory(sf);
        return manager;
    }

    private Properties getProps() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect", dialect);
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        return props;
    }
}
