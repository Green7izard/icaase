package nl.dare2date.matching.interests.SocialMediaConnection;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * Created by Bas on 7-10-2015.
 */
@DynamicUpdate
@javax.persistence.Entity
@Table(appliesTo = "SOCIALMEDIACONNECTIONS")
public class SocialMediaInformation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "interest_id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "auth_token")
    private String authToken;

    @Enumerated(EnumType.STRING)
    @Column(name= "type")
    SocialMediaType type;

    @Column(name="validated")
    Boolean validated;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public SocialMediaType getType() {
        return type;
    }

    public void setType(SocialMediaType type) {
        this.type = type;
    }

    public Boolean isValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }
}
