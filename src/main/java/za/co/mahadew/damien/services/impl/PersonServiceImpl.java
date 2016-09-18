package za.co.mahadew.damien.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import za.co.mahadew.damien.models.Laptop;
import za.co.mahadew.damien.models.Person;
import za.co.mahadew.damien.services.DatabaseService;
import za.co.mahadew.damien.services.LaptopService;
import za.co.mahadew.damien.services.NotificationService;
import za.co.mahadew.damien.services.OptionalService;
import za.co.mahadew.damien.services.PersonService;


/**
 * Created by DAMIEN6 on 17/09/2016.
 */
@Component
//There are other options
//@Profile("dev")
@Scope("singleton")
@Lazy(value = false)
public class PersonServiceImpl implements PersonService {


    //Example of Field injection
    //Autowired resolution rules
    //1. look for unique bean of required type
    //2. use @qualifier if supplied
    //3. try to find a matching bean by name
    // if no unique bean and no qualifier user, the following will be used to look for an ID
    // 1. void setVal(MyClass object) -- looks for bean with id = val
    // 2. void myBean(MyClass val) -- looks for bean with id = val
    // 3. @Autowired private MyClass val -- looks for bean with id = val
    @Autowired
    @Qualifier("databaseServiceImpl") // if you remove this you will get an exception saying there are two beans
            //We use a qualifier because we have DatabaseServiceImpl and MockDatabaseServiceImpl
    DatabaseService databaseService;

    NotificationService notificationService;

    LaptopService laptopService;

    //An example of an optional dependency -- if you are doing this make sure you check if its not null before using the object
    @Autowired(required = false)
    OptionalService optionalService;

    //With java 8 - Optional service
//    @Autowired
//    private Optional<OptionalService> optionalService2;




    //Example of Constructor injection
    //Use when : mandatory dependencies
    // immutable dependencies
    // concise(pass several params at once)
    @Autowired
    public PersonServiceImpl(NotificationService notificationService) {
        this.notificationService = notificationService;
    }


    public Laptop getPersonsLaptopDetails(Person person) {
        return null;
    }

    public Person getPerson(String name) {
        Person person = (Person) databaseService.read(name);
        return person;
    }

    //Example of Setter injection
    // USe when : optional or changeable dependencies
    // circular dependencies
    // inherited automatically
    @Autowired
    public void setLaptopService(LaptopService laptopService) {
        this.laptopService = laptopService;
    }
}
