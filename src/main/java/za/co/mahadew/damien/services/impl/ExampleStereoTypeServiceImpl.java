package za.co.mahadew.damien.services.impl;

import za.co.mahadew.damien.services.DatabaseService;
import za.co.mahadew.damien.services.ExampleStereoTypeService;
import za.co.mahadew.damien.services.NotificationService;
import za.co.mahadew.damien.stereotypes.ExampleStereoType;

import javax.annotation.Resource;

/**
 * Created by DAMIEN6 on 17/09/2016.
 */
@ExampleStereoType
public class ExampleStereoTypeServiceImpl implements ExampleStereoTypeService {

    /**
     *  Using @Resource
     *  identifies dependencies by name and not by type
     *  @Autowired matches by type
     *  Supports only setter and field injection only
     *
     *  If no name is supplied, inferred from property/field name or falls back on injection byb type
     *
     */

    @Resource(name = "mockDatabaseServiceImpl")
    DatabaseService databaseService;

    NotificationService notificationService;

    public NotificationService getNotificationService() {
        return notificationService;
    }

    @Resource(name = "notifcationServiceImpl")
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public void doNothing() {

    }

}
