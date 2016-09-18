package za.co.mahadew.damien.services.impl;

import org.springframework.stereotype.Component;
import za.co.mahadew.damien.services.DatabaseService;

/**
 * Created by DAMIEN6 on 17/09/2016.
 */
@Component("mockDatabaseServiceImpl") // We set a name to the bean
//Since there are two beans implementing Database service - there could be some confusion when trying to reference DatabaseService as there will be 2 beans defined.
//In order to solve this, we declare the names and when calling a specific databaseservice we specify the qualifier -- see PersonServiceImpl
public class MockDatabaseServiceImpl implements DatabaseService {

    public boolean save(Object object) {
        return false;
    }

    public Object read(Object object) {
        return null;
    }
}
