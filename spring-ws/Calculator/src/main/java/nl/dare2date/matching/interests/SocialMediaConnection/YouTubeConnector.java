package nl.dare2date.matching.interests.socialMediaConnection;

import nl.dare2date.matching.interests.Interest;
import nl.dare2date.matching.interests.InterestType;
import nl.dare2date.matching.orchestration.MessageState;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    private static final String GOOGLE_URL = "https://www.googleapis.com/";
    //private static final String GOOGLE_URL = "http://localhost:8080/cheating/";

    private static final String YOUTUBE_URL = GOOGLE_URL+"youtube/v3/";
    public static final String AUTH_TOKEN_MARK = "${AUTH_TOKEN}";


    private static final String VALIDATE_URL = GOOGLE_URL +"oauth2/v1/tokeninfo?access_token="+AUTH_TOKEN_MARK;
     //private static final String VALIDATE_URL = YOUTUBE_URL +"oauth2/v1/tokeninfo?access_token="+AUTH_TOKEN_MARK;

    private static final String GET_SUBSCRIPTIONS = YOUTUBE_URL+ "subscriptions?part=snippet&mine=true&access_token="+AUTH_TOKEN_MARK+"&key="+GOOGLE_ID;
    public static final String ID_MARK = "${ID}";
    private static final String GET_CATEGORY = YOUTUBE_URL+"guideCategories?part=snippet&key="+GOOGLE_ID+"&id="+ID_MARK;


    @Override
    public SocialMediaType getType() {
        return SocialMediaType.YOUTUBE;
    }

    @Override
    public StatusMessage validate(SocialMediaInformation information) {
        if(information==null||information.getAuthToken()==null || information.getAuthToken().isEmpty())
        {
            return new StatusMessage(MessageState.INVALID_AUTH_TOKEN, "No auth token supplied!");
        }
        String requestUrl = VALIDATE_URL.replace(AUTH_TOKEN_MARK, information.getAuthToken());
        try {
            doGet(requestUrl);
            information.setValidated(true);
            return new StatusMessage(MessageState.SUCCEEDED, "Successfully connected to Youtube! We will now see what you watch everyday!");
        } catch (IOException e) {
            information.setValidated(false);
            return new StatusMessage(MessageState.INVALID_AUTH_TOKEN, e.getMessage());
        }
    }

    @Override
    public List<Interest> getInterests(SocialMediaInformation information) {
        if(information.isValidated())
        {
            try {
                JSONObject subscriptions = new JSONObject(doGet(GET_SUBSCRIPTIONS.replace(AUTH_TOKEN_MARK, information.getAuthToken())));
                if (subscriptions.isNull("error")) {
                    information.setValidated(false);
                    return new ArrayList<Interest>(0);
                }
                JSONArray array = subscriptions.getJSONArray("items");
                List<Interest> interests = new ArrayList<>(20);
                for (int i = 0; i < array.length(); i++) {
                    try {
                        Interest interest = new Interest();
                        interest.setSource(this.getType());
                        JSONObject snippet = array.getJSONObject(i).getJSONObject("Snippet");
                        interest.setName(snippet.getString("title"));
                        String channelID = snippet.getString("channelId");
                        JSONArray categories = new JSONObject(doGet(GET_CATEGORY.replace(ID_MARK, channelID))).getJSONArray("items");
                        interest.setType(getCategory(categories.getJSONObject(0).getJSONObject("snippet").getString("title")));
                        interests.add(interest);
                    }
                    catch(Exception e)
                    {
                        
                    }
                }

                //Process information
                return interests;
            }
            catch(IOException e)
            {
                return new ArrayList<Interest>(0);
            }
        }
        else{
            return new ArrayList<Interest>(0);
        }
    }

    private InterestType getCategory(String string) {
        switch(string)
        {
            case "Film & Animation": return InterestType.MOVIE;
            case "Autos & Vehicles": return InterestType.TRANSPORTATION;
            case "Music": return InterestType.MUSIC;
            case "Pets & Animals": return InterestType.ANIMAL;
            case "Sports": return InterestType.SPORT;
            case "Short Movies": return InterestType.MOVIE;
            case "Travel & Events": return InterestType.TRAVEL;
            case "Gaming": return InterestType.GAME;
            case "Comedy": return InterestType.CREATIVE;
            case "News & Politics": return InterestType.POLITICS;
            case "Howto & Style": return InterestType.CLOTHING;
            case "Movies": return InterestType.MOVIE;
            case "Anime/Animation": return InterestType.TVSERIES;
            case "Shorts": return InterestType.MOVIE;
            case "Shows": return InterestType.TVSERIES;
            default: return InterestType.OTHER;
        }
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
