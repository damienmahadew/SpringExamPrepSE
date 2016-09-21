package za.co.mahadew.damien.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import za.co.mahadew.damien.models.Laptop;

/**
 * Created by DAMIEN6 on 14/09/2016.
 */
@Configuration
public class BusinessConfig {

    @Bean
    @Scope("singleton")
    // Scopes can be : singleton; prototype; request; session; custom
    public String getBusinessConfigBean() {
        return "bus config bean";
    }

    @Bean
    @Scope("prototype")
    public Laptop laptopPrototypeBean() {
        return new Laptop();
    }

}
