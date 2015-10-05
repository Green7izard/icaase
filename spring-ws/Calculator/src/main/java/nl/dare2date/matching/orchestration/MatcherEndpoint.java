package nl.dare2date.matching.orchestration;

import nl.dare2date.matching.interests.InterestManager;
import nl.dare2date.matching.matching.Matcher;
import nl.ead.webservice.services.IMoviePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Endpoint for the matcher service! //FIXME It does absolutly nothing at all!
 * Created by Bas on 28-9-2015.
 */
@Endpoint
public class MatcherEndpoint {

    private static final String NAMESPACE_URI = "http://www.dare2date.nl/matching";

    private final Matcher matcher;
    private final InterestManager manager;

    @Autowired
    public MatcherEndpoint(Matcher matcher, InterestManager interestManager){
        this.matcher=matcher;
        this.manager=interestManager;
    }

    @PayloadRoot(localPart = "getMatchRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public GetMatchResponse getMatches(@RequestPayload GetMatchRequest matchRequest)
    {
        return new GetMatchResponse();
    }

    @PayloadRoot(localPart = "connectSocialMediaRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public ConnectSocialMediaResponse connectSocialMedia(@RequestPayload ConnectSocialMediaRequest matchRequest)
    {

        ConnectSocialMediaResponse response = new ConnectSocialMediaResponse();
        response.setResult(manager.connectSocialMedia(matchRequest.getUserID(),
                //Point to the Version in the interests because that one is used for internal systems
                nl.dare2date.matching.interests.SocialMediaConnection.SocialMediaType.fromSoap(matchRequest.getSocialMediaType()),
                matchRequest.getSocialMediaPassword(),
                matchRequest.getSocialMediaUserName()).toSoap());
        return response;
    }
}
