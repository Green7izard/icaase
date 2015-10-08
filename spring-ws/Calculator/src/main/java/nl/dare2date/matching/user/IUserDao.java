package nl.dare2date.matching.user;

import nl.dare2date.matching.interests.Interest;
import nl.dare2date.matching.interests.socialMediaConnection.SocialMediaInformation;
import nl.dare2date.matching.matching.Preferences;

import java.util.List;

/**
 * Interface for access into the database
 */
public interface IUserDao {
    /**
     * Get the specified user
     * @param id user id
     * @return the user!
     */
    User getUser(long id);

    /**
     * Gets users by their preferences
     * @param ownId id of the user requesting the search
     * @param prefs preferences that should be applied
     * @return a list of users
     */
    List<User> getUsers(long ownId, Preferences prefs);

    /**
     * Saves the users data
     * @param user the user to be saved
     */
    User saveData(User user);

    /**
     * Saves the interest data
     * @param interest the interest
     */
    void saveInterest(Interest interest);

    /**
     * Saves the social media information for a user
     * @param socialinfo the inforamtion to be stored
     */
    void saveSocialMedia(SocialMediaInformation socialinfo);
}
