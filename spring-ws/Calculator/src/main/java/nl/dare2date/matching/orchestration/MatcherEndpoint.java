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
        prefs.setMaxAge(matchRequest.getMaxAge());
        prefs.setMinAge(matchRequest.getMinAge());
        prefs.setMaxHeight(matchRequest.getMaxHeight());
        prefs.setMinHeight(matchRequest.getMinHeight());
        prefs.setMaxWeight(matchRequest.getMaxWeight());
        prefs.setMinWeight(matchRequest.getMinWeight());
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
