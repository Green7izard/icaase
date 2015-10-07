package nl.dare2date.matching.interests.SocialMediaConnection;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import nl.dare2date.matching.interests.Interest;
import nl.dare2date.matching.orchestration.MessageState;

import java.util.List;

/**
 * Created by Bas on 6-10-2015.
 */
public class FaceBookConnector implements SocialMediaConnector {
    @Override
    public StatusMessage validate(String authToken) {
        if(authToken==null ||authToken.isEmpty())
        {
            return new StatusMessage(MessageState.INVALID_AUTH_TOKEN, "No token supplied!");
        }
        //TODO
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId("1661710374113587", "20220f5ad0ecab259a29d07e5a873a51");
        facebook.setOAuthPermissions("public_profile, user_about_me");
        facebook.setOAuthAccessToken(new AccessToken(authToken));
        try {
            if ((facebook.getOAuthAccessToken().getExpires()==null||facebook.getOAuthAccessToken().getExpires() > 0)
                    &&facebook.getUserLikes()!=null)
            {
                //TODO store that shizzle
                return new StatusMessage(MessageState.SUCCEEDED, "Connected to FaceBook! All your info now belongs to us!");
            }
            else
            {
                return new StatusMessage(MessageState.OTHER_PROBLEM,"Token expired!, Please relog to your FaceBook!");
            }
        }
        catch(IllegalStateException e)
        {
            return new StatusMessage(MessageState.INVALID_AUTH_TOKEN, e.getMessage());
        }
        catch(FacebookException e)
        {
            switch(e.getStatusCode())
            {
                case 190: return new StatusMessage(MessageState.INVALID_AUTH_TOKEN, e.getMessage());
                case 102: return new StatusMessage(MessageState.AUTH_TOKEN_EXPIRED, e.getMessage());
                case 1: return new StatusMessage(MessageState.TIME_OUT, "Could not reach FaceBook");
                case 2: return new StatusMessage(MessageState.TIME_OUT, "Could not reach FaceBook");
                case 4:  return new StatusMessage(MessageState.OTHER_PROBLEM, e.getMessage());
                case 10: return new StatusMessage(MessageState.AUTH_TOKEN_EXPIRED, e.getMessage());
                case 341: return new StatusMessage(MessageState.OTHER_PROBLEM, "Dare2Date Facebook limit reached");
                case 467: return new StatusMessage(MessageState.INVALID_AUTH_TOKEN, e.getMessage());
                default: return new StatusMessage(MessageState.OTHER_PROBLEM, e.getMessage());
            }
        }
    }

    @Override
    public List<Interest> getInterests(String authToken) {
        return null;
    }
}
