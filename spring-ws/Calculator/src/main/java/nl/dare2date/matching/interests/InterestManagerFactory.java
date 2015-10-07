package nl.dare2date.matching.interests;

import nl.dare2date.matching.interests.SocialMediaConnection.SocialMediaFactory;

/**
 * Created by Bas on 5-10-2015.
 */
public class InterestManagerFactory {
    public InterestManager create() {
        return new InterestManager(new SocialMediaFactory());
    }
}
