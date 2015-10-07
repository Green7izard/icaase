package nl.dare2date.matching.matching;

import nl.dare2date.matching.user.User;

/**
 * A match for a user
 */
public class Match implements Comparable<Match> {

    private User matchedUser;
    private int score;

    /**
     * Create the match
     * @param matchedUser the user that was matched against
     * @param score the matching score
     */
    public Match(User matchedUser, int score) {
        this.score = score;
        this.matchedUser = matchedUser;
    }

    /**
     * @return orchestration representation of this object
     */
    public nl.dare2date.matching.orchestration.Match toOrchestration() {
        nl.dare2date.matching.orchestration.Match returnVal = new nl.dare2date.matching.orchestration.Match();
        returnVal.setScore(score);
        returnVal.setUserID(matchedUser.getId());
        returnVal.setName(matchedUser.getName());
        return returnVal;
    }

    /**
     * Compare this match against a different match based on their score
     * @param o the other match
     * @return otherscore - this ones score
     */
    @Override
    public int compareTo(Match o) {
        return o.score - score;
    }
}
