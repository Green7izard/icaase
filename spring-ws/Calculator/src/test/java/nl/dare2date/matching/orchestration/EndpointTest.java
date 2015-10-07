package nl.dare2date.matching.orchestration;

import nl.dare2date.matching.interests.InterestManager;
import nl.dare2date.matching.interests.SocialMediaConnection.*;
import nl.dare2date.matching.matching.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;


/**
 * Created by Bas on 5-10-2015.
 */
public class EndpointTest {

    MatcherEndpoint endpoint;
    Matcher matcher;
    InterestManager interestManager;

    /**
     * Prepare some steps before
     */
    @Before
    public void setUp(){
        //Mock the matcher so that it does nothing
        matcher = Mockito.mock(Matcher.class);
        //Same for the intrest manager
        interestManager = Mockito.mock(InterestManager.class);
        //Create the endpoint with the mocks
        endpoint = new MatcherEndpoint(matcher, interestManager);
    }

    /**
     * test that the connectSocialMedia function gets delegated properly
     */
    @Test
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
        nl.dare2date.matching.interests.SocialMediaConnection.StatusMessage status = Mockito.spy(new nl.dare2date.matching.interests.SocialMediaConnection.StatusMessage(state, message));
        //Make Mockito return status when the connectsocialmedia is called
        Mockito.when(interestManager.connectSocialMedia(Matchers.anyLong(), (nl.dare2date.matching.interests.SocialMediaConnection.SocialMediaType) Matchers.any(), Matchers.anyString())).thenReturn(status);
        //Do the fucntion we want to test
        ConnectSocialMediaResponse response = endpoint.connectSocialMedia(request);
        // Verify the interaction with out interestmanager mock
        Mockito.verify(interestManager).connectSocialMedia(Matchers.eq(userId), Matchers.eq(nl.dare2date.matching.interests.SocialMediaConnection.SocialMediaType.fromSoap(type)), Matchers.eq(password));
        //Verfify the transformation
        Mockito.verify(status).toSoap();
        //Check the response
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getResult());
        Assert.assertEquals(message, response.getResult().getMessage());
        Assert.assertEquals(state, response.getResult().getState());
    }
}
