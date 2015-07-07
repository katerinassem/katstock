package by.itechart.katstock.configuration;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.dialect.Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by katsiaryna.siamikina on 07.07.2015.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"by.itechart.katstock.repository"})
@PropertySource("classpath:persistance.properties")
public class JpaConfiguration {

    private final String ENTITY_PACKAGE = "by.itechart.katstock.entity";

    private final String DATASOURCE_DRIVER_CLASS_NAME_PROP_KEY = "datasource.driver_class_name";
    private final String DATASOURCE_URL_PROP_KEY = "datasource.url";
    private final String DATASOURCE_USERNAME_PROP_KEY = "datasource.username";
    private final String DATASOURCE_PASSWORD_PROP_KEY = "datasource.password";

    private final String HIBERNATE_DIALECT_PROP_KEY = "hibernate.dialect";
    private final String HIBERNATE_SHOW_SQL_PROP_KEY = "hiberanate.show_sql";
    private final String HIBERNATE_FORMAT_SQL_PROP_KEY = "hibernate.format_sql";

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource(){

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty(DATASOURCE_DRIVER_CLASS_NAME_PROP_KEY));
        dataSource.setUrl(environment.getProperty(DATASOURCE_URL_PROP_KEY));
        dataSource.setUsername(environment.getProperty(DATASOURCE_USERNAME_PROP_KEY));
        dataSource.setPassword(environment.getProperty(DATASOURCE_PASSWORD_PROP_KEY));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){

        LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactory.setDataSource(dataSource());
        entityManagerFactory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactory.setPackagesToScan(ENTITY_PACKAGE);
        entityManagerFactory.setJpaProperties(getHibernateProperties());

        return entityManagerFactory;
    }

    private Properties getHibernateProperties(){

        Properties properties = new Properties();
        properties.setProperty(org.hibernate.cfg.Environment.DIALECT, environment.getProperty(HIBERNATE_DIALECT_PROP_KEY));
        properties.setProperty(org.hibernate.cfg.Environment.SHOW_SQL, environment.getProperty(HIBERNATE_SHOW_SQL_PROP_KEY));
        properties.setProperty(org.hibernate.cfg.Environment.FORMAT_SQL, environment.getProperty(HIBERNATE_FORMAT_SQL_PROP_KEY));

        return properties;
    }

    @Bean
    public JpaTransactionManager transactionManager(){

        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        jpaTransactionManager.setDataSource(dataSource());

        return jpaTransactionManager;
    }
}
