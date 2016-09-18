package za.co.mahadew.damien.services;

import za.co.mahadew.damien.models.Laptop;
import za.co.mahadew.damien.models.Person;

/**
 * Created by DAMIEN6 on 17/09/2016.
 */
public interface PersonService {

    Laptop getPersonsLaptopDetails(Person person);

    Person getPerson(String name);
}
