package za.co.mahadew.damien.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import za.co.mahadew.damien.models.Person;

/**
 * Created by DAMIEN6 on 14/09/2016.
 */
@Configuration
@PropertySource("classpath:/environment.properties")
public class InfrastructureConfig {

    @Value("${surname}")
    private String surname ;


    //Spring Expression Language SpEL -- the below will give you damien6
//    @Value("#{systemProperties.user.name}")
//    private String userName ;

    //Another example of spring expression language
    //First create a bean of an object
    @Bean
    public Person person() {
        return new Person("Damien", 25);
    }

    @Value("#{person.age}")
    private Integer personsAge;


    @Autowired
    Environment environment;

    @Bean
//    @Profile("dev")
    public String getInfrastructureConfigBean() {
        return "infrastructure config bean";
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public String testingProp() {
        return environment.getProperty("name");
    }

    @Bean
    public String testingPropFromPropertiesPlaceholder() {
        return surname;
    }


    @Bean
    public String personsAgeSpELTesting() {
        return personsAge.toString();
    }
}
