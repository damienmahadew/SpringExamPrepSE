package za.co.mahadew.damien.repositories;

import za.co.mahadew.damien.models.Laptop;
import za.co.mahadew.damien.models.Person;

import java.util.List;
import java.util.Map;

/**
 * Created by damien.mahadew on 2016-10-16.
 */
public interface LaptopRepository {

    int getLaptopCount();

    int getLaptopCountOfMake(String make);

    Map<String, Object> getLaptopInfo(String id);

    List<Map<String, Object>> getLaptops(String type);

    Laptop getLaptop(String id);

    List<Laptop> getAllLaptops();

    void generateReport();

    Person getPersonsOwningLaptop(String laptop);

    int addLaptop(Laptop laptop);

    int updateLaptop(Laptop laptop);

}
