package nl.dare2date.matching.interests;

import nl.dare2date.matching.interests.socialMediaConnection.*;
import nl.dare2date.matching.orchestration.MessageState;
import nl.dare2date.matching.user.IUserDao;
import nl.dare2date.matching.user.User;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/**
 * Manages the interests of a user
 */
public class InterestManager {

    private final IUserDao userDao;
    private final SocialMediaFactory factory;

    /**
     * Creates the manager
     * @param factory the social media factory that supplies connectors
     * @param dao the DataBaseAccess
     */
    public InterestManager(SocialMediaFactory factory, IUserDao dao) {
        this.factory = factory;
        userDao = dao;
    }

    /**
     * Connects a user to the social media
     * @param userID ID of the user that wants to connect stuff
     * @param type The social media type
     * @param smAuthToken the Authentication token of the user
     * @return a message concerning the status
     */
    public StatusMessage connectSocialMedia(long userID, SocialMediaType type, String smAuthToken) {
        SocialMediaInformation info = new SocialMediaInformation();
        info.setValidated(false);
        info.setAuthToken(smAuthToken);
        info.setType(type);
        StatusMessage returnVal = factory.validate(info);
        if (info.isValidated()) {
            final User currentUser = userDao.getUser(userID);
            SocialMediaInformation oldInfo = null;
            if(currentUser==null)
            {
                return new StatusMessage(MessageState.OTHER_PROBLEM, "UserID not correct");
            }
            for(SocialMediaInformation information: currentUser.getConnectedSocialMedia())
            {
                if(information.getType() == info.getType())
                {
                    information.setAuthToken(info.getAuthToken());
                    oldInfo=information;
                    userDao.mergeSocialMedia(oldInfo);
                    break;
                }
            }
            if(oldInfo==null) {
                info.setUser(currentUser);
                currentUser.getConnectedSocialMedia().add(info);
                userDao.saveSocialMedia(info);
            }
            userDao.saveData(currentUser);
            new Thread(new Runnable(){
                @Override
                public void run() {
                    updateInterests(currentUser);
                }
            }).start();

        }
        return returnVal;
    }

    /**
     * Updates the interests of a user
     * @param user the user whom interests will be updated
     */
    public void updateInterests(final User user) {
        User updatedUser = user;
        for(SocialMediaInformation info: user.getConnectedSocialMedia())
        {
            if(info.isValidated()) {
               SocialMediaConnector connector = factory.getConnector(info.getType());
                List<Interest> interests = connector.getInterests(info);
                if(interests!=null && !interests.isEmpty()) {
                    for (Iterator<Interest> it = updatedUser.getInterests().iterator(); it.hasNext(); ) {
                        Interest interest = it.next();
                        try {
                            userDao.deleteInterest(interest);
                        }
                        catch(Exception e)
                        {
                            System.out.println("Caught: "+e.getMessage());
                        }
                        it.remove();
                    }
                    for (Interest interest : interests) {
                        interest.setUser(updatedUser);
                        updatedUser.getInterests().add(interest);
                        userDao.saveInterest(interest);
                    }
                    updatedUser = userDao.saveData(updatedUser);
                }
            }
        }
    }
}
