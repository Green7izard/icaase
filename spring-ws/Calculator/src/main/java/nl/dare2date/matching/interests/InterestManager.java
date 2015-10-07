package nl.dare2date.matching.interests;

import nl.dare2date.matching.interests.SocialMediaConnection.SocialMediaFactory;
import nl.dare2date.matching.interests.SocialMediaConnection.SocialMediaInformation;
import nl.dare2date.matching.interests.SocialMediaConnection.SocialMediaType;
import nl.dare2date.matching.interests.SocialMediaConnection.StatusMessage;
import nl.dare2date.matching.user.User;

/**
 * Created by Bas on 5-10-2015.
 */
public class InterestManager {
    private final SocialMediaFactory factory;

    public InterestManager(SocialMediaFactory factory) {
        this.factory = factory;
    }

    public StatusMessage connectSocialMedia(long userID, SocialMediaType type, String smAuthToken) {
        SocialMediaInformation info = new SocialMediaInformation();
        info.setValidated(false);
        info.setAuthToken(smAuthToken);
        info.setType(type);
        StatusMessage returnval = factory.validate(info);
        if (info.isValidated()) {
            info.setUserId(userID);
            //TODO GET USER
            //TODO STORE THIS DATA
        }
        return returnval;
    }

    public void updateInterests(User user) {
        //TODO update interests?
    }
}
