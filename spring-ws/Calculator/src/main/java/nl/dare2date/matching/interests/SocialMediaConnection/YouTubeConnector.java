package nl.dare2date.matching.interests.SocialMediaConnection;

import nl.dare2date.matching.interests.Interest;

import java.util.List;

/**
 * Created by Bas on 6-10-2015.
 */
public class YouTubeConnector implements SocialMediaConnector{

    private static final String GOOGLE_ID ="423827042740-6o5c3tue58ta7m7ovf93cglg3kcnnhce.apps.googleusercontent.com";
    private static final String GOOGLE_SECRET ="oTMoXqqsqk3L9Py6EU9t7ieR";

    @Override
    public StatusMessage validate(String authToken) {
        return null;
    }

    @Override
    public List<Interest> getInterests(String authToken) {
        return null;
    }
}
