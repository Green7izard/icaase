package nl.dare2date.matching.matching;

import nl.dare2date.matching.user.IUserDao;
import nl.dare2date.matching.user.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Bas on 5-10-2015.
 */
public class Matcher {
    private static final int THREADS = 8;
    private final IUserDao userDao;

    public Matcher(IUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Matches all user to the specified preferences
     *
     * @param id    id of the user that wants to match
     * @param prefs a object holding his preferences
     * @return a list of matches
     */
    public List<Match> getMatch(long id, Preferences prefs) {
        User matchingUser = userDao.getUser(id);
        if (matchingUser == null) {
            throw new IllegalArgumentException("Not a valid user!");
        }
        List<User> users = userDao.getUsers(id, prefs);
        MatchRunner[] threads = new MatchRunner[THREADS];
        int numberOfUsersPerThread = users.size() / THREADS;
        if (users.size() % THREADS > 0) {
            numberOfUsersPerThread++;
        }
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new MatchRunner(matchingUser, numberOfUsersPerThread);
            for (int j = 0; j < numberOfUsersPerThread; j++) {
                if (!users.isEmpty()) {
                    User currentUser = users.get(0);
                    users.remove(0);
                    threads[i].users.add(currentUser);
                }
            }
            threads[i].start();
        }
        users=null;
        List<Match> returnList = new ArrayList<Match>(users.size());
        for (int i = 0; i < THREADS; i++) {
            try {
                threads[i].join();
                for (Match match : threads[i].matches) {
                    returnList.add(match);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(returnList);
        return returnList;
    }

    /**
     * Inner class to divert workload to
     */
    private class MatchRunner extends Thread {

        private final User baseUser;
        private List<User> users;
        private List<Match> matches;
        /**
         * Create the MatchRunner
         *
         * @param baseUser the user that will be compared to
         * @param size base size of the list
         */
        private MatchRunner(User baseUser, int size) {
            this.baseUser = baseUser;
            users = new ArrayList<User>(size);
        }

        /**
         * Creates matches from the User list
         */
        @Override
        public void run() {
            matches = new ArrayList<Match>(users.size());
            for (User userToMatch : users) {
                users.remove(userToMatch);
                matches.add(userToMatch.match(baseUser));
            }
            users=null;
        }
    }
}
