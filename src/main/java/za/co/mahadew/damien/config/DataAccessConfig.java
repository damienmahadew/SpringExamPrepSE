package za.co.mahadew.damien.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.validation.annotation.Validated;

import javax.sql.DataSource;


/**
 * Created by damien.mahadew on 2016-10-16.
 */
@Configuration
public class DataAccessConfig {

    /**
     * Creating an embedded database
     * Look at database-config.xml for jdbc namespace
     */
    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder.setName("testDbName")
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("classpath://databasescripts/data.sql")
                .addScript("classpath://databasescripts/schema.sql").build();
    }


    /**
     * The configs below execute the scripts in an existing datasource
     */
    @Value("classpath://databasescripts/data.sql") private Resource dataSql;
    @Value("classpath://databasescripts/schema.sql") private Resource schemSql;

    private DatabasePopulator databasePopulator() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.addScript(dataSql);
        populator.addScript(schemSql);
        return populator;
    }

    @Bean
    public DataSourceInitializer anyName(final DataSource dataSource) {
        final DataSourceInitializer dataSourceInitializer = new DataSourceInitializer();
        dataSourceInitializer.setDatabasePopulator(databasePopulator());
        dataSourceInitializer.setDataSource(dataSource);
        return dataSourceInitializer;
    }
}
