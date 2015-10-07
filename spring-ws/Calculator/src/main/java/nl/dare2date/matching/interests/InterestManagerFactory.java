package nl.dare2date.matching.interests;

import nl.dare2date.matching.interests.SocialMediaConnection.SocialMediaFactory;
import nl.dare2date.matching.user.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bas on 5-10-2015.
 */
public class InterestManagerFactory {
    @Autowired
    IUserDao userDao;

    /**
     * Creates a InterestManager
     * @return a interestManager
     */
    public InterestManager create() {
        return new InterestManager(new SocialMediaFactory(), userDao);
    }
}
