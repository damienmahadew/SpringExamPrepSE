package za.co.mahadew.damien.lifecycle;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by damien.mahadew on 2016-09-19.
 */
@Component
public class InitializerExample {

    /**
     * The method below is an example of the initialization step
     */


    @PostConstruct
    public void postConstruct() {

    }

    @PreDestroy
    public void preDestroy(){

    }
}
