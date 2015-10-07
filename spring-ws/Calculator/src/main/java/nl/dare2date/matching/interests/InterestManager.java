package nl.dare2date.matching.interests;

import nl.dare2date.matching.interests.SocialMediaConnection.*;
import nl.dare2date.matching.orchestration.MessageState;
import nl.dare2date.matching.user.IUserDao;
import nl.dare2date.matching.user.User;

/**
 * Created by Bas on 5-10-2015.
 */
public class InterestManager {

    private final IUserDao userDao;
    private final SocialMediaFactory factory;

    public InterestManager(SocialMediaFactory factory, IUserDao dao) {
        this.factory = factory;
        userDao = dao;
    }

    public StatusMessage connectSocialMedia(long userID, SocialMediaType type, String smAuthToken) {
        SocialMediaInformation info = new SocialMediaInformation();
        info.setValidated(false);
        info.setAuthToken(smAuthToken);
        info.setType(type);
        StatusMessage returnVal = factory.validate(info);
        if (info.isValidated()) {
            User currentUser = userDao.getUser(userID);
            if(currentUser==null)
            {
                return new StatusMessage(MessageState.OTHER_PROBLEM, "UserID not correct");
            }
            info.setUserId(userID);
            currentUser.getConnectedSocialMedia().add(info);
            userDao.saveSocialMedia(info);
            userDao.saveData(currentUser);
            //Turn this into a async?
            updateInterests(currentUser);
        }
        return returnVal;
    }

    public void updateInterests(final User user) {
        User updatedUser = user;
        for(SocialMediaInformation info: user.getConnectedSocialMedia())
        {
            if(info.isValidated()) {
                for (Interest interest : factory.getConnector(info.getType()).getInterests(info)) {
                    interest.setUserId(updatedUser.getId());
                    user.getIntrests().add(interest);
                    userDao.saveInterest(interest);
                }
                updatedUser = userDao.saveData(updatedUser);
            }
        }
    }
}
