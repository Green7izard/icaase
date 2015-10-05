package nl.dare2date.matching.interests;


import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bas on 5-10-2015.
 */
@DynamicUpdate
@javax.persistence.Entity
@Table(appliesTo = "INTEREST")
public class Interest implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private InterestType type;

    public Interest(){}
    public Interest(String name, InterestType type)
    {
        this.name=name;
        this.type=type;
    }

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public InterestType getType() {
        return type;
    }

    public void setType(InterestType type) {
        this.type = type;
    }
}
