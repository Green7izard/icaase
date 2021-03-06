package nl.dare2date.matching.orchestration;

import nl.dare2date.matching.interests.InterestManager;
import nl.dare2date.matching.matching.Matcher;
import nl.dare2date.matching.matching.Preferences;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

/**
 * Endpoint for the matcher service!
 * Created by Bas on 28-9-2015.
 */
@Endpoint
public class MatcherEndpoint {

    private static final String NAMESPACE_URI = "http://www.dare2date.nl/matching";

    private final Matcher matcher;
    private final InterestManager manager;

    /**
     * Create the endpoint
     * @param matcher the matcher for matching
     * @param interestManager the interest manager for connecting social media
     */
    @Autowired
    public MatcherEndpoint(Matcher matcher, InterestManager interestManager) {
        this.matcher = matcher;
        this.manager = interestManager;
    }

    /**
     * Get matches
     * @param matchRequest the request
     * @return a response with a list of matches
     */
    @PayloadRoot(localPart = "getMatchRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public GetMatchResponse getMatches(@RequestPayload GetMatchRequest matchRequest) {
        Preferences prefs = new Preferences();
        prefs.setCity(matchRequest.getCity());
        prefs.setCountry(matchRequest.getCountry());
        prefs.setGender(nl.dare2date.matching.user.Gender.fromOrchestration(matchRequest.getGender()));
        if(matchRequest.getMaxAge()!=null) {
            prefs.setMaxAge(matchRequest.getMaxAge().longValue());
        }
        else
        {
            prefs.setMaxAge(200);
        }
        if(matchRequest.getMinAge()!=null) {
            prefs.setMinAge(matchRequest.getMinAge().longValue());
        }
        else
        {
            prefs.setMinAge(18);
        }
        if(matchRequest.getMaxHeight()!=null) {
            prefs.setMaxHeight(matchRequest.getMaxHeight().longValue());
        }
        else
        {
            prefs.setMaxHeight(500);
        }
        if(matchRequest.getMinHeight()!=null) {
            prefs.setMinHeight(matchRequest.getMinHeight().longValue());
        }
        else
        {
            prefs.setMinHeight(50);
        }
        if(matchRequest.getMaxWeight()!=null) {
            prefs.setMaxWeight(matchRequest.getMaxWeight().longValue());
        }
        else
        {
            prefs.setMaxWeight(500);
        }
        if(matchRequest.getMinWeight()!=null) {
            prefs.setMinWeight(matchRequest.getMinWeight().longValue());
        }
        else
        {
            prefs.setMinWeight(30);
        }
        prefs.setMinimalEducationLevel(nl.dare2date.matching.user.Education.fromOrchestration(matchRequest.getMinimalEducationLevel()));
        prefs.setReligion(nl.dare2date.matching.user.Religion.fromOrchestration(matchRequest.getReligion()));

        List<nl.dare2date.matching.matching.Match> receivedList = matcher.getMatch(matchRequest.getUserID(), prefs);
        GetMatchResponse response = new GetMatchResponse();
        response.result = new ArrayList<Match>(receivedList.size());
        for (nl.dare2date.matching.matching.Match match : receivedList) {
            response.result.add(match.toOrchestration());
        }
        return response;
    }

    /**
     * Connect a user to social media
     * @param matchRequest the request
     * @return a response with a status message
     */
    @PayloadRoot(localPart = "connectSocialMediaRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public ConnectSocialMediaResponse connectSocialMedia(@RequestPayload ConnectSocialMediaRequest matchRequest) {

        ConnectSocialMediaResponse response = new ConnectSocialMediaResponse();
        response.setResult(manager.connectSocialMedia(matchRequest.getUserID(),
                //Point to the Version in the interests because that one is used for internal systems
                nl.dare2date.matching.interests.socialMediaConnection.SocialMediaType.fromOrchestration(matchRequest.getSocialMediaType()),
                matchRequest.getSocialMediaAuthenticationToken()).toOrchestration());
        return response;
    }
}
