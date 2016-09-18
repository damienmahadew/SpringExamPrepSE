package za.co.mahadew.damien.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

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
}
