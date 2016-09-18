package za.co.mahadew.damien.services.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import za.co.mahadew.damien.models.Person;
import za.co.mahadew.damien.services.NotificationService;

/**
 * Created by DAMIEN6 on 17/09/2016.
 */
@Service
/**
 * Stereotypes -- can be created and be used , spring has a few of them predefined i.e.
 * 1. @Service -- service classes
 * 2. @Controller -- web classes - spring mvc
 * 3. @Configuration -- java config
 * 4. @Repository -- data access classes
 */
public class NotifcationServiceImpl implements NotificationService {
    public void publishChanges(Person person) {

    }
}
