package nl.dare2date.matching.orchestration;

import nl.dare2date.matching.interests.InterestManager;
import nl.dare2date.matching.matching.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.naming.NamingException;


/**
 * Created by Bas on 5-10-2015.
 */
public class EndpointTest {

    MatcherEndpoint endpoint;
    Matcher matcher;
    ConnectionFactory factory;
    /**
     * Prepare some steps before
     */
    @Before
    public void setUp() throws NamingException, JMSException {
        //Mock the matcher so that it does nothing
        matcher = Mockito.mock(Matcher.class);
        factory = Mockito.mock(ConnectionFactory.class);
        //Create the endpoint with the mocks
        endpoint = new MatcherEndpoint(matcher, factory);
    }

    /**
     * test that the connectSocialMedia function gets delegated properly
     */
    //@Test
    public void testConnectSocialMediaConnect(){
        //Set up basic values for the test
        long userId = 5;
        String password = "gfdsgfsdgfsdg435435sdfgse46";
        nl.dare2date.matching.orchestration.SocialMediaType type = nl.dare2date.matching.orchestration.SocialMediaType.FACE_BOOK;
        //Create the request
        ConnectSocialMediaRequest request = new ConnectSocialMediaRequest();
        request.setSocialMediaAuthenticationToken(password);
        request.setSocialMediaType(type);
        request.setUserID(userId);
        //Prepare a return message
        MessageState state = MessageState.DATABASE_ERROR;
        String message = "Failure";
        //SPy at the statusmessage so that we can check if functions are called
        nl.dare2date.matching.interests.socialMediaConnection.StatusMessage status = Mockito.spy(new nl.dare2date.matching.interests.socialMediaConnection.StatusMessage(state, message));
        //Make Mockito return status when the connectsocialmedia is called
        //Mockito.when(interestManager.connectSocialMedia(Matchers.anyLong(), (nl.dare2date.matching.interests.socialMediaConnection.SocialMediaType) Matchers.any(), Matchers.anyString())).thenReturn(status);
        //Do the fucntion we want to test
        ConnectSocialMediaResponse response = endpoint.connectSocialMedia(request);
        // Verify the interaction with out interestmanager mock
        //Mockito.verify(interestManager).connectSocialMedia(Matchers.eq(userId), Matchers.eq(nl.dare2date.matching.interests.socialMediaConnection.SocialMediaType.fromOrchestration(type)), Matchers.eq(password));
        //Verfify the transformation
        Mockito.verify(status).toOrchestration();
        //Check the response
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getResult());
        Assert.assertEquals(message, response.getResult().getMessage());
        Assert.assertEquals(state, response.getResult().getState());
    }

}
