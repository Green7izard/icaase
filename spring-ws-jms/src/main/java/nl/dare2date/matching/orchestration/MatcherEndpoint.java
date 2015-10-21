package nl.dare2date.matching.orchestration;

import nl.dare2date.matching.interests.InterestManager;
import nl.dare2date.matching.matching.Matcher;
import nl.dare2date.matching.matching.Preferences;
import nl.han.dare2date.service.jms.util.JMSUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.NamingException;
import java.io.Serializable;
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
    private final ConnectionFactory factory;

    /**
     * Create the endpoint
     * @param matcher the matcher for matching
     */
    @Autowired
    public MatcherEndpoint(Matcher matcher, ConnectionFactory ConnectionFactory) {
        this.matcher = matcher;
        factory=ConnectionFactory;
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
        try {
            SocialMediaRequestor requestor = new SocialMediaRequestor(getConnection());
            requestor.setPayload(matchRequest);
            requestor.setCorrelationID(matchRequest.getUserID() + "Request");
            requestor.send();
            Serializable jmsResponse=null;
            requestor.receiveSync();
            jmsResponse =requestor.getResponse();
            if(jmsResponse instanceof StatusMessage)
            {
                response.setResult((StatusMessage) jmsResponse);
                return response;
            }
            else
            {
                StatusMessage message = new StatusMessage();
                message.setMessage("Received nothing usefull from the que "+jmsResponse);
                message.setState(MessageState.OTHER_PROBLEM);
                response.setResult(message);
                return response;
            }
        } catch (NamingException e) {
            e.printStackTrace();
            StatusMessage message = new StatusMessage();
            message.setMessage(e.getMessage());
            message.setState(MessageState.OTHER_PROBLEM);
            response.setResult(message);
            return response;
        } catch (JMSException e) {
            e.printStackTrace();
            StatusMessage message = new StatusMessage();
            message.setMessage(e.getMessage());
            message.setState(MessageState.OTHER_PROBLEM);
            response.setResult(message);
            return response;
        } catch(Exception e)
        {
            e.printStackTrace();
            StatusMessage message = new StatusMessage();
            message.setMessage(e.getMessage());
            message.setState(MessageState.OTHER_PROBLEM);
            response.setResult(message);
            return response;
        }
        /*response.setResult(manager.connectSocialMedia(matchRequest.getUserID(),
                //Point to the Version in the interests because that one is used for internal systems
                nl.dare2date.matching.interests.socialMediaConnection.SocialMediaType.fromOrchestration(matchRequest.getSocialMediaType()),
                matchRequest.getSocialMediaAuthenticationToken()).toOrchestration());
        return response;*/
    }

    private Connection getConnection() throws JMSException {
        Connection con = factory.createConnection();
        con.start();
        return con;
    }
}
