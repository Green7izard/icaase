package nl.dare2date.matching.matching;

import nl.dare2date.matching.user.Education;
import nl.dare2date.matching.user.Gender;
import nl.dare2date.matching.user.Religion;

/**
 * Created by Bas on 5-10-2015.
 */
public class Preferences {
    private Gender gender;
    private long maxAge;
    private long minAge;
    private long maxWeight;
    private long minWeight;
    private long maxHeight;
    private long minHeight;
    private String country;
    private String city;
    private Religion religion;
    private Education minimalEducationLevel;

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setMaxAge(long maxAge) {
        this.maxAge = maxAge;
    }

    public void setMinAge(long minAge) {
        this.minAge = minAge;
    }

    public void setMaxWeight(long maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setMinWeight(long minWeight) {
        this.minWeight = minWeight;
    }

    public void setMaxHeight(long maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void setMinHeight(long minHeight) {
        this.minHeight = minHeight;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public void setMinimalEducationLevel(Education minimalEducationLevel) {
        this.minimalEducationLevel = minimalEducationLevel;
    }
}
