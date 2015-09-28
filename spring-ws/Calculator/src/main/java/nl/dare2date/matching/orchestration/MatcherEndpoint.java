package nl.dare2date.matching.orchestration;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Endpoint for the matcher service! //FIXME It does absolutly nothing at all!
 * Created by Bas on 28-9-2015.
 */
@Endpoint
public class MatcherEndpoint {

    @PayloadRoot(localPart = "getMatchRequest", namespace = "http://www.dare2date.nl/matching")
    @ResponsePayload
    public GetMatchResponse getMatches(GetMatchRequest matchRequest)
    {
        return null;
    }

    @PayloadRoot(localPart = "connectSocialMediaRequest", namespace = "http://www.dare2date.nl/matching")
    @ResponsePayload
    public ConnectSocialMediaResponse getMatches(ConnectSocialMediaRequest matchRequest)
    {
        return null;
    }
}
