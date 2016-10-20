package za.co.mahadew.damien.domain;

import javax.persistence.*;

/**
 * Created by damien.mahadew on 2016-10-19.
 */
@Entity
@Table(name = "embeddables")
public class EmbeddablesEntity {

    @Id
    @Column(name = "id")
    private long id;

    @Embedded
    @AttributeOverride(name = "idNo", column = @Column(name = "identityNumber"))
    private EmbeddablesClass embeddablesClass;
    //The above takes the value in column identityNumber of table embeddables
    //and creates the EmbeddableClass object and sets the idNo to the column value
}
