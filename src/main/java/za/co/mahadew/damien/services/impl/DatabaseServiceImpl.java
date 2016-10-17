package za.co.mahadew.damien.services.impl;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import za.co.mahadew.damien.services.DatabaseService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by DAMIEN6 on 17/09/2016.
 */
@Component("databaseServiceImpl") //Using @Component gives this bean an id derived from the class name i.e. databaseServiceImpl
//If you are using @Component you need to make sure your components are scanned in the configuration either in java or xml

//This allows disambiguation - common strategy - acoid using qualifiers as it is rare to have two beans of the same type
@Transactional(timeout = 60) //Applies @Transactional to all methods of this class
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

    @Transactional(timeout = 45) // Overrides the original timeout of 60 at the class level
    public boolean save(Object object) {
        //do something here
        return false;
    }

    public Object read(Object object) {
        return null;
    }


    /**
     * Examples of isolation levels
     */
    @Transactional(isolation = Isolation.READ_UNCOMMITTED)
    public void exampleReadUncommitted() {
        //Lowest isolation level - allows dirty reads
        //Current transaction can see the results of another uncommitted unit of work
        //Typically used for large, intrusive, read-only transactions
        //And or whether data is consistently changing
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void exampleReadCommitted() {
        // Does not allow dirty reads
        //Default strategy for most databases
    }

    /**Highest isolation levels*/
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void exampleRepeatableRead() {
        //Does not allow dirty reads
        //Non- repeatable reads are prevented
            //- if a row is read twice in a transaction, the result is always the same
            // this may result in locking???
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void exampleSerializable() {
        //prevents non repeatable reads and dirty reads
        // also prevents phantom reads?
        //        A phantom read occurs when, in the course of a transaction, two identical queries
        //      are executed, and the collection of rows returned by the second query is different from the first

    }

    /**
     * Propagation levels examples
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void exampleRequired() {
        //This propagation is the default
        // Execute within a current transaction, creates a new one if nothing exists
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void exampleRequiresNew() {
        //Creates new transaction, suspending the current one if there is
    }

    /**
     * Overriding default rollback rules
     */
    @Transactional(rollbackFor = Exception.class,
            noRollbackFor = DataAccessException.class)
    public void exampleOverridingDefaultRollbackSettings() {
        //rollbackFor -- will only rollback the tx if the exception is stated here
        //noRollbackFor -- will not rollback the transaction if exception is stated here
    }


}
