package nl.dare2date.matching.interests.socialMediaConnection;

import nl.dare2date.matching.orchestration.MessageState;
import nl.dare2date.matching.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Factory class for the social media connectors
 */
public class SocialMediaFactory {

    /**
     * The classes
     */
    private static Map<SocialMediaType, SocialMediaConnector> classes=  new HashMap<SocialMediaType, SocialMediaConnector>();

    static{
        classes.put(SocialMediaType.FACEBOOK, new FaceBookConnector());
        classes.put(SocialMediaType.YOUTUBE, new YouTubeConnector());
    }
    /**
     * Gets a connector
     *
     * @param type type of desired social media
     * @return a connector if correct, null if not correct
     */
    public SocialMediaConnector getConnector(SocialMediaType type) {
        /*switch (type) {
            case FACEBOOK:
                return new FaceBookConnector();
            case YOUTUBE:
                return new YouTubeConnector();
            default:
                return null;
        }*/
        return classes.get(type);
    }

    /**
     * Gets all possible connectors for a user
     *
     * @param user The user that needs connectors
     * @return A list of social media connectors
     */
    public List<SocialMediaConnector> getConnectors(User user) {
        List<SocialMediaConnector> returnList = new ArrayList<SocialMediaConnector>(user.getConnectedSocialMedia().size());
        for (SocialMediaInformation info : user.getConnectedSocialMedia()) {
            if (info.isValidated()) {
                SocialMediaConnector connector = getConnector(info.type);
                if (connector != null && !returnList.contains(connector)) {
                    returnList.add(connector);
                }
            }
        }
        return returnList;
    }

    /**
     * Validates information at the correct
     *
     * @param info the informtation that needs to be validated
     * @return a message concerning the state of the operation
     */
    public StatusMessage validate(SocialMediaInformation info) {

        SocialMediaConnector connector = getConnector(info.type);
        if (connector != null) {
            return connector.validate(info);
        } else {
            return new StatusMessage(MessageState.OTHER_PROBLEM, "Invalid Social media type");
        }
    }
}
