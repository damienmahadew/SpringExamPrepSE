package za.co.mahadew.damien.services.impl;

import org.springframework.stereotype.Component;
import za.co.mahadew.damien.services.DatabaseService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by DAMIEN6 on 17/09/2016.
 */
@Component("databaseServiceImpl") //Using @Component gives this bean an id derived from the class name i.e. databaseServiceImpl
//If you are using @Component you need to make sure your components are scanned in the configuration either in java or xml

//This allows disambiguation - common strategy - acoid using qualifiers as it is rare to have two beans of the same type
public class DatabaseServiceImpl implements DatabaseService {

    @PostConstruct
    public void populateCache() {
        /**
         * This method is called at startup after all dependency injection, after constructor + setters
         * This method can have any visibility but can only return void and take in no params
         */
    }

    /**
     * The PostConstruct and PreDestroy methods can also be defined in the
     * @Bean annotation i.e. @Bean(initMethod="populateCache", destroyMethod="cleanCache")
     * Generally use this method for classes you have not written i.e libraries
     */

    @PreDestroy
    public void cleanCache() {
        /**
         * This method is called at shutdown, prior to destroying the bean instance
         * Called when JVM exits normally
         * Not called for prototype beanss
         * * This method can have any visibility but can only return void and take in no params
         */
    }

    public boolean save(Object object) {
        //do something here
        return false;
    }

    public Object read(Object object) {
        return null;
    }
}
