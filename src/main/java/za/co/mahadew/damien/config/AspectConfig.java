package za.co.mahadew.damien.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Created by damien.mahadew on 2016-09-20.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"za.co.mahadew.damien.aspects"})
public class AspectConfig {
}
