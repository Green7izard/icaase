package nl.dare2date.matching.matching;

import nl.dare2date.matching.user.User;

/**
 * Created by Bas on 5-10-2015.
 */
public class Match {

    private User matchedUser;
    private int score;

    public Match(User matchedUser, int score)
    {
        this.score=score;
        this.matchedUser = matchedUser;
    }

    public nl.dare2date.matching.orchestration.Match toSoap()
    {
        nl.dare2date.matching.orchestration.Match returnVal = new nl.dare2date.matching.orchestration.Match();
        returnVal.setScore(score);
        returnVal.setUserID(matchedUser.getUserId());
        return returnVal;
    }

}
