package za.co.mahadew.damien.domain;

import za.co.mahadew.damien.models.Laptop;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by damien.mahadew on 2016-10-19.
 */
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @Column(name = "id")
    private long id;

    @OneToMany
    @JoinColumn(name = "id") //foreign key association
    private Set<Laptop> laptops;
}
