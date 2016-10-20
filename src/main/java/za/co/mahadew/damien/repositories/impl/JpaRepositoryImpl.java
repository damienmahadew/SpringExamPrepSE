package za.co.mahadew.damien.repositories.impl;

import za.co.mahadew.damien.models.Laptop;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by damien.mahadew on 2016-10-19.
 */
public class JpaRepositoryImpl {

    private EntityManager entityManager;

    /**
     * Querying with named params
     */
    public List<Laptop> exampleQueryingWithNamedParams() {
//        Query query = entityManager.createQuery("select l from Laptop l where l.make = :make");
//        query.setParameter("make", "yourMakeOfLaptop");
//        return (List<Laptop>) query.getResultList();
        // can combine it
        //entityManager.createQuery("select l from Laptop l where l.make = :make")
        // .query.setParameter("make", "yourMakeOfLaptop")
        // .getResultList();

        //can also getSingleResult() if only one result will be returned
        return null;
    }
}
