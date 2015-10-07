package nl.dare2date.matching.user;

import nl.dare2date.matching.interests.Interest;
import nl.dare2date.matching.interests.SocialMediaConnection.SocialMediaConnector;
import nl.dare2date.matching.interests.SocialMediaConnection.SocialMediaInformation;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Bas on 5-10-2015.
 */
@DynamicUpdate
@Entity
@Table(appliesTo = "USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "USER")
    @JoinColumn(name = "id")
    List<Interest> interests;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "USER")
    @JoinColumn(name = "connected_social_media")
    List<SocialMediaInformation> connectedSocialMedia;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "age")
    private long age;

    @Column(name = "height")
    private long height;

    @Column(name = "weight")
    private long weight;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "religion")
    private Religion religion;

    @Column(name = "education_level")
    @Enumerated(EnumType.ORDINAL)
    private Education educationLevel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Education getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(Education educationLevel) {
        this.educationLevel = educationLevel;
    }

    public List<Interest> getIntrests() {
        return interests;
    }

    public void setIntrests(List<Interest> intrests) {
        this.interests = intrests;
    }

    public List<SocialMediaInformation> getConnectedSocialMedia() {
        return connectedSocialMedia;
    }

    public void setConnectedSocialMedia(List<SocialMediaInformation> connectedSocialMedia) {
        this.connectedSocialMedia = connectedSocialMedia;
    }
}
