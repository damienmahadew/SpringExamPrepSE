package za.co.mahadew.damien.services;

import za.co.mahadew.damien.models.Person;

/**
 * Created by DAMIEN6 on 17/09/2016.
 */
public interface NotificationService {
    void publishChanges(Person person);
}
