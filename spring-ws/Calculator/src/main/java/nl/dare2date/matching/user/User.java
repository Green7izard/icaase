package nl.dare2date.matching.user;

import nl.dare2date.matching.interests.Interest;
import nl.dare2date.matching.interests.socialMediaConnection.SocialMediaInformation;
import nl.dare2date.matching.matching.Match;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Table;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Bas on 5-10-2015.
 */
@DynamicUpdate
@Entity
@Table(name = "user")
public class User implements Serializable {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    List<Interest> interests;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    List<SocialMediaInformation> connectedSocialMedia;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long id;

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
    @Enumerated(EnumType.STRING)
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

    public List<Interest> getInterests() {
        return interests;
    }

    public void setInterests(List<Interest> intrests) {
        this.interests = intrests;
    }

    public List<SocialMediaInformation> getConnectedSocialMedia() {
        return connectedSocialMedia;
    }

    public void setConnectedSocialMedia(List<SocialMediaInformation> connectedSocialMedia) {
        this.connectedSocialMedia = connectedSocialMedia;
    }

    /**
     * Create a match
     * @param baseUser the user to be matched
     * @return A match with this as the user and a comparison score
     */
    public Match match(User baseUser) {
        int score = 0;
        for(Interest interest : getInterests())
        {
            if(baseUser.hasInterest(interest))
            {
                score++;
            }
        }
        double calcScore = score;
        calcScore= calcScore/((double)baseUser.getInterests().size());
        return new Match(this, (int)(calcScore*100.d));
    }

    public boolean hasInterest(Interest interest)
    {
        for(Interest ownInterest : getInterests())
        {
            if(ownInterest.isEqualTo(interest))
            {
                return true;
            }
        }
        return false;
    }
}
