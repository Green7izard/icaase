package nl.dare2date.matching.matching;

import nl.dare2date.matching.user.IUserDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Bas on 5-10-2015.
 */
public class MatcherFactory {
    @Autowired
    IUserDao userDao;

    /**
     * @return a new matcher
     */
    public Matcher create() {
        return new Matcher(userDao);
    }
}
