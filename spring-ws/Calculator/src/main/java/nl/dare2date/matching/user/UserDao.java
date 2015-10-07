package nl.dare2date.matching.user;

import nl.dare2date.matching.interests.Interest;
import nl.dare2date.matching.interests.SocialMediaConnection.SocialMediaInformation;
import nl.dare2date.matching.matching.Preferences;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Bas on 5-10-2015.
 */
@Repository
public class UserDao implements IUserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public User getUser(long id) {
        return em.find(User.class, id);
    }

    @Override
    @Transactional
    public User saveData(User user) {
        return em.merge(user);
    }

    @Override
    @Transactional
    public void saveInterest(Interest interest) {
        em.persist(interest);
    }

    @Override
    @Transactional
    public void saveSocialMedia(SocialMediaInformation interest) {
        em.persist(interest);
    }

    @Override
    public List<User> getUsers(long ownId, Preferences prefs) {
        //TODO
        return null;
    }
}
