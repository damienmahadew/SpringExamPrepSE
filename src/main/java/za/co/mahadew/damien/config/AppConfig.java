package za.co.mahadew.damien.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by DAMIEN6 on 14/09/2016.
 */
@Configuration
@ImportResource({"classpath:/spring-config.xml", "classpath:/cache-config.xml"}) //import xml configuration
@Import({InfrastructureConfig.class, BusinessConfig.class, AnnotationConfig.class, AspectConfig.class, CacheConfig.class})
public class AppConfig {

    @Bean(name = "getHelloWorld")
    public String getHelloWorld() {
        return "hello world from spring";
    }

    /**
     * Java config vs Annotation
     *
     * Java Config
     * Pros:
     * 1. Centralized
     * 2. Write any java code you need
     * 3. strong type checking
     * 4. can be used for all classes, not just your own i.e. create beans from libraries
     *
     * cons:
     * More verbose
     *
     *
     * Annotations
     * Pros:
     * 1. Nice for frequently changing beans
     * 2. Single place to edit
     * 3. Allows for rapid development
     *
     * Cons:
     * 1. Config spread across code base - harder to debug or maintain
     * 2.Only works for your own code
     * 3. merges config and code - bad separation of concern
     */

    /**
     * Beans can be create in the normal way
     * 1. @Bean
     * 2. found and created by the component scanner
     * 3. Spring invokes them automatically
     *
     * But these are not spring annotations
     * 1. defined by JSR-250 in javax.annotation package
     * Also supported by EJB3
     */

}
