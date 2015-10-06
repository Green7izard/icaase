package nl.dare2date.matching.interests.SocialMediaConnection;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import nl.dare2date.matching.interests.Interest;

import java.util.List;

/**
 * Created by Bas on 6-10-2015.
 */
public class FaceBookConnector implements SocialMediaConnector {
    @Override
    public StatusMessage validate(String authToken) {
        //TODO
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId("1661710374113587", "20220f5ad0ecab259a29d07e5a873a51");
        facebook.setOAuthPermissions("");//TODO set permissions
        facebook.setOAuthAccessToken(new AccessToken(authToken, null));//TODO set auth token
        return null;
    }

    @Override
    public List<Interest> getInterests(String authToken) {
        return null;
    }
}
