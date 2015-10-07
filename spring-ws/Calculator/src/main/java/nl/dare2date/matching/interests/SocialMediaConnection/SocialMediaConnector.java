package nl.dare2date.matching.interests.SocialMediaConnection;

import nl.dare2date.matching.interests.Interest;

import java.util.List;

/**
 * Description of a social media connector
 */
public interface SocialMediaConnector {

    /**
     * Validates the given object
     *
     * @param info the information object, Object will have IsValidated() == true after a succesfull operation
     * @return A message containing detailed information about the process.
     */
    StatusMessage validate(SocialMediaInformation info);

    /**
     * Gets a list of Interests from a social media
     *
     * @param info the information that is needed
     * @return a list of Interests
     */
    List<Interest> getInterests(SocialMediaInformation info);

    /**
     * Return the type of this connector
     */
    SocialMediaType getType();

}
