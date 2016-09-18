package za.co.mahadew.damien.services;

/**
 * Created by DAMIEN6 on 17/09/2016.
 */
public interface DatabaseService {
    boolean save(Object object);
    Object read(Object object);
}
