package za.co.mahadew.damien.repositories;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import za.co.mahadew.damien.models.Laptop;
import za.co.mahadew.damien.models.Person;

/**
 * Created by damien.mahadew on 2016-10-16.
 */
public class PersonRepository {

    /**
     * @Cacheable marks a method for caching - result is stored in a map
     * Can add attributes - see below
     */
    @Cacheable(value = "person", key = "#refId.toUpperCase()")
    public Person findPerson(String refId) {
        //do Something
        return null;
    }

    /**
     * Can also cache based on conditions
     */
    @Cacheable(value = "personCache", key = "#refId", condition = "#refId.length() > 10")
    public Person findPerson1(String refId, boolean check) {
        //Do something
        return null;
    }

    /**
     * Can also cache based on object property
     */
    @Cacheable(value = "personCache", key = "#laptop.make")
    public Person findPerson2(Laptop laptop, boolean check) {
        //Do something
        return null;
    }

    /**
     * Can also cache based on custom key generator
     */
    @Cacheable(value = "personCache", key = "T(example.KeyGen).hash(#refId)")
    public Person findPerson3(String refId, boolean check) {
        //Do something
        return null;
    }

    /**
     * Clears cache before method is invoked
     */

    @CacheEvict(value = "personCache")
    public void loadBooks() {}
}