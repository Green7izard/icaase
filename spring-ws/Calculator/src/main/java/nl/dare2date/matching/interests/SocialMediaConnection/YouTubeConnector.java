package nl.dare2date.matching.interests.socialMediaConnection;

import nl.dare2date.matching.interests.Interest;
import nl.dare2date.matching.orchestration.MessageState;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by Bas on 6-10-2015.
 */
public class YouTubeConnector implements SocialMediaConnector {

    /*
    * Get google Auth Token with:
    * https://accounts.google.com/o/oauth2/auth?
scope=email%20profile https://gdata.youtube.com&
state=DERP&
redirect_uri=http://localhost:8080/&
response_type=code&
client_id=423827042740-6o5c3tue58ta7m7ovf93cglg3kcnnhce.apps.googleusercontent.com&
access_type=offline&
approval_prompt=force
     */

    private static final String GOOGLE_ID = "423827042740-6o5c3tue58ta7m7ovf93cglg3kcnnhce.apps.googleusercontent.com";
    private static final String GOOGLE_SECRET = "oTMoXqqsqk3L9Py6EU9t7ieR";

    private static final String VALIDATE_URL = "https://www.googleapis.com/oauth2/v1/tokeninfo?access_token=";
    private static final String YOUTUBE_URL = "https://gdata.youtube.com/";


    @Override
    public SocialMediaType getType() {
        return SocialMediaType.YOUTUBE;
    }

    @Override
    public StatusMessage validate(SocialMediaInformation information) {
        if(information==null||information.getAuthToken()==null || information.getAuthToken().isEmpty())
        {
            return new StatusMessage(MessageState.INVALID_AUTH_TOKEN, "No authtoken supplied!");
        }
        String requestUrl = VALIDATE_URL + information.getAuthToken();
        try {
            doGet(requestUrl);
            information.setValidated(true);
            return new StatusMessage(MessageState.SUCCEEDED, "Succesfully connected to Youtube! We will now see what you watch!");
        } catch (IOException e) {
            information.setValidated(false);
            return new StatusMessage(MessageState.INVALID_AUTH_TOKEN, e.getMessage());
        }
    }

    @Override
    public List<Interest> getInterests(SocialMediaInformation information) {
        return null;
    }


    /**
     * Execute a get request to a URL
     *
     * @param url the url
     * @return the response as a string
     * @throws IOException Something went badly
     */
    public String doGet(String url) throws IOException {
        URL request = new URL(url);
        URLConnection connection = request.openConnection();
        BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuffer returnString = new StringBuffer();
        while ((line = input.readLine()) != null) {
            returnString.append(line);
        }
        input.close();
        return returnString.toString();
    }
}
