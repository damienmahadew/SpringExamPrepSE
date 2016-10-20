package za.co.mahadew.damien.domain;

import za.co.mahadew.damien.models.Person;

import javax.persistence.*;

/**
 * Created by damien.mahadew on 2016-10-19.
 */
@Entity //mandatory
@Table(name = "laptop") //optional
public class LaptopEntity {

    @Id //mandatory
    @Column(name = "id") //optional
    private Long id;

    @Column
    private String laptop;

    @Transient //this will not be persisted
    private Person person;

    private String make;

    @Column(name = "make")
    public String getMake() {
        return make;
    }

    //Setters are not compulsory
}
