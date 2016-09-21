package za.co.mahadew.damien.services;

import za.co.mahadew.damien.models.Laptop;

/**
 * Created by DAMIEN6 on 17/09/2016.
 */
public interface LaptopService {
    String getLaptopDetails(Laptop laptop);

    String getTestExceptionThrowing(Laptop laptop);
}
