package nl.dare2date.matching.user;

import nl.dare2date.matching.matching.Preferences;

import java.util.List;

/**
 * Created by Bas on 5-10-2015.
 */
public interface IUserDao {
    User getUser(long id);
    List<User> getUsers(long ownId, Preferences prefs);
}
