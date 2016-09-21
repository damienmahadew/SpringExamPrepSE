package za.co.mahadew.damien.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import za.co.mahadew.damien.models.Laptop;
import za.co.mahadew.damien.services.LaptopService;

/**
 * Created by DAMIEN6 on 17/09/2016.
 */
@Component
//When component/bean names are not identified -- de capitalize non qualified class names by default
//But will pick up implementation details from className
public class LaptopServiceImpl implements LaptopService {

    private String make;
    private String model;

    @Value("#{environment['name']}")
    private String testWithoutUsingCOnstructorOrSetter;

    @Value("#{environment['novalue']?: 'noValue'}")
    private String testSpELWithNoValueInproperties;

    @Value("${novalue:noValue2}")
    private String testWithNoValueInproperties;
//
//    public String getTest() {
//        return testWithoutUsingCOnstructorOrSetter;
//    }
//
//    public void setTest(String testWithoutUsingCOnstructorOrSetter) {
//        this.testWithoutUsingCOnstructorOrSetter = testWithoutUsingCOnstructorOrSetter;
//    }

    //Example of using @Value to set attributes in constructor
    @Autowired // u need this autowired in here otherwise the program will fail - failed to instantiate - no default constructor found
    public LaptopServiceImpl(@Value("#{environment['laptop']}") String model) {
        this.model = model;
    }

    public String getLaptopDetails(Laptop laptop) {
        laptop.setModel(" new Model for aspect testing");
        return make + " - " + model + " - " + testWithoutUsingCOnstructorOrSetter
                + " - " + testSpELWithNoValueInproperties + " - " + testWithNoValueInproperties;
    }

    public String getTestExceptionThrowing(Laptop laptop) {
        throw new RuntimeException(" Ok i am throwing a runtime exception");
    }

    public String getMake() {
        return make;
    }

    @Autowired
    public void setMake(@Value("#{environment['laptop_make']}") String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
