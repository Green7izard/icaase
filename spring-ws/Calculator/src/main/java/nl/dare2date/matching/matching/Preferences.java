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

    public Gender getGender() {
        return gender;
    }

    public long getMaxAge() {
        if(maxAge>=minAge) {
            return maxAge;
        }
        else{
            return 200;
        }
    }

    public long getMinAge() {
        if(minAge<18)
        {
            return 18;
        }
        else {
            return minAge;
        }
    }

    public long getMaxWeight() {
        if(maxWeight>=getMinWeight()) {
            return maxWeight;
        }
        else{
            return 1000;
        }
    }

    public long getMaxHeight() {
        if(maxHeight>=getMinHeight()) {
            return maxHeight;
        }
        else {
            return 300;
        }
    }

    public long getMinWeight() {
        if(minWeight>0) {
            return minWeight;
        }
        else return 0;
    }

    public long getMinHeight() {
        if(minHeight<50) {
            return minHeight;
        }else{
            return 50;
        }
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Religion getReligion() {
        return religion;
    }

    public Education getMinimalEducationLevel() {
        return minimalEducationLevel;
    }
}
