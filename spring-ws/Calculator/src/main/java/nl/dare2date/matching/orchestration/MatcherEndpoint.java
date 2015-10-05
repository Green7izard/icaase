package nl.dare2date.matching.orchestration;

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

    @Autowired
    public MatcherEndpoint(IMoviePrinter moviePrinter){

    }

    @PayloadRoot(localPart = "getMatchRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public GetMatchResponse getMatches(@RequestPayload GetMatchRequest matchRequest)
    {
        return new GetMatchResponse();
    }

    @PayloadRoot(localPart = "connectSocialMediaRequest", namespace = NAMESPACE_URI)
    @ResponsePayload
    public ConnectSocialMediaResponse getMatches(@RequestPayload ConnectSocialMediaRequest matchRequest)
    {

        return new ConnectSocialMediaResponse();
    }
}
