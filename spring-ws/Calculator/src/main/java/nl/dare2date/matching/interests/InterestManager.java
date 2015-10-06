package nl.dare2date.matching.interests;

import nl.dare2date.matching.interests.SocialMediaConnection.SocialMediaFactory;
import nl.dare2date.matching.interests.SocialMediaConnection.SocialMediaType;
import nl.dare2date.matching.interests.SocialMediaConnection.StatusMessage;
import nl.dare2date.matching.user.User;

/**
 * Created by Bas on 5-10-2015.
 */
public class InterestManager {
    private final SocialMediaFactory factory;
    public InterestManager(SocialMediaFactory socialMediaFactory) {
        factory=socialMediaFactory;
    }

    public StatusMessage connectSocialMedia(long userID, SocialMediaType type, String smAuthToken)
    {
        //TODO STUFF
        return null;
    }

    public void updateInterests(User user)
    {
        //TODO update interests?
    }
}
