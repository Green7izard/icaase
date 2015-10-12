package nl.dare2date.matching.user;

import nl.dare2date.matching.interests.Interest;
import nl.dare2date.matching.interests.socialMediaConnection.SocialMediaInformation;
import nl.dare2date.matching.matching.Preferences;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Bas on 5-10-2015.
 */
@Repository
public class UserDao implements IUserDao {

    @PersistenceContext
    private EntityManagerFactory em;

    @Override
    @Transactional
    public User getUser(long id) {
        return em.createEntityManager().find(User.class, id);
    }

    @Override
    @Transactional
    public User saveData(User user) {
        return em.createEntityManager().merge(user);
    }

    @Override
    @Transactional
    public void saveInterest(Interest interest) {
        em.createEntityManager().persist(interest);
    }

    @Override
    @Transactional
    public void deleteInterest(Interest interest){em.createEntityManager().remove(interest);}

    @Override
    @Transactional
    public void saveSocialMedia(SocialMediaInformation interest) {
        em.createEntityManager().persist(interest);
    }

    @Override
    public List<User> getUsers(long ownId, Preferences prefs) {
        //Create hql string
        String hql = "from User where gender = :gender and (age >= :minage and age<=:maxage) and (height >= :minheight and height<=:maxheight) and (weight >= :minweight and weight<=:maxweight) and user_id != :user_id";
       //It is possible that these values havent been filled out
        if(prefs.getCity()!=null && !prefs.getCity().isEmpty())
        {
            hql += " and city = :city";
        }
        if(prefs.getCountry()!=null && !prefs.getCountry().isEmpty())
        {
            hql += " and country = :country";
        }
        if(prefs.getReligion()!=null)
        {
            hql += " and religion = :religion";
        }
        if(prefs.getMinimalEducationLevel()!=null)
        {
            hql += " and education_level > :education_level";
        }
        //Create the query
        Query query = em.createEntityManager().createQuery(hql);
        //Protected way to input the parameters
        query.setParameter("user_id", ownId);
        query.setParameter("gender", prefs.getGender());
        query.setParameter("minage", prefs.getMinAge());
        query.setParameter("maxage", prefs.getMaxAge());
        query.setParameter("minheight", prefs.getMinHeight());
        query.setParameter("maxheight", prefs.getMaxHeight());
        query.setParameter("minweight", prefs.getMinWeight());
        query.setParameter("maxweight", prefs.getMaxWeight());
        //input the optional parameters
        if(prefs.getCity()!=null && !prefs.getCity().isEmpty())
        {
           query.setParameter("city", prefs.getCity());
        }
        if(prefs.getCountry()!=null && !prefs.getCountry().isEmpty())
        {
            query.setParameter("country", prefs.getCountry());
        }
        if(prefs.getReligion()!=null)
        {
            query.setParameter("religion", prefs.getReligion());
        }
        if(prefs.getMinimalEducationLevel()!=null)
        {
            query.setParameter("education_level", prefs.getMinimalEducationLevel());
        }
        //Get the result
        return query.getResultList();
    }
}
