package nl.dare2date.matching.interests;


import nl.dare2date.matching.interests.socialMediaConnection.SocialMediaType;
import nl.dare2date.matching.user.User;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Table;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Bas on 5-10-2015.
 */
@DynamicUpdate
@javax.persistence.Entity
@Table(name = "interest")
public class Interest implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "source")
    SocialMediaType source;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "interest_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "name")
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private InterestType type;

    public Interest() {
    }

    public Interest(String name, InterestType type) {
        this.name = name;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    public SocialMediaType getSource() {
        return source;
    }

    public void setSource(SocialMediaType source) {
        this.source = source;
    }

    /**
     * Check if one interest is equal to another, does not look at the ID or the source
     * @param other the other interest to compare to
     * @return true if its equal, false if its not
     */
    public boolean isEqualTo(Interest other)
    {
        if(other!=null) {
            return type == other.type && this.name.equalsIgnoreCase(other.name);
        }
        return false;
    }
}
