package nl.dare2date.matching.interests.socialMediaConnection;

import nl.dare2date.matching.user.User;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * Created by Bas on 7-10-2015.
 */
@DynamicUpdate
@javax.persistence.Entity
@Table(appliesTo = "socialmediaconnection")
public class SocialMediaInformation {

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    SocialMediaType type;
    @Column(name = "validated")
    Boolean validated;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "interest_id")
    private long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @Column(name = "user_id")
    private User userId;
    @Column(name = "auth_token")
    private String authToken;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return userId;
    }

    public void setUser(User userId) {
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
