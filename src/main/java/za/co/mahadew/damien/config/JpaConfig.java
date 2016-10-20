package za.co.mahadew.damien.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by damien.mahadew on 2016-10-19.
 */
@Configuration
@Import({DataAccessConfig.class})
public class JpaConfig {

    @Autowired
    DataSource dataSource;


    /**
     * JPA and spring
     * creating an entityManagerfactory bean
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabase(Database.HSQL);

        Properties props = new Properties();
        props.setProperty("hibernate.format_sql", "true");

        LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
        emfb.setDataSource(dataSource);
        emfb.setPackagesToScan("za.co.mahadew.damien.domain"); // no need for persistence.xml if you have this
        emfb.setJpaProperties(props);
        emfb.setJpaVendorAdapter(adapter);
        return  emfb;
    }
}
