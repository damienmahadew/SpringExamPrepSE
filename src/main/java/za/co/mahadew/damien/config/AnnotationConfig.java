package za.co.mahadew.damien.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by DAMIEN6 on 17/09/2016.
 */
@Configuration
@ComponentScan("za.co.mahadew.damien.services.impl") //This creates the beans in the folder with annotation @Component or any derived form of @component
//Components are scanned at startup, therefore can take some time if many files, best practice is including specific folders
public class AnnotationConfig {
}
