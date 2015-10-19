package nl.dare2date.matching.interests.socialMediaConnection;

import static org.junit.Assert.*;

import nl.dare2date.matching.orchestration.MessageState;
import org.junit.Test;

/**
 * Created by Bas on 6-10-2015.
 */
public class YouTubeConnectorTest {

    YouTubeConnector youtube = new YouTubeConnector();

    @Test
    public void testConnectionWithBadStuff(){
        SocialMediaInformation a =new SocialMediaInformation();
        a.setAuthToken("THIS WONT BE ALLOWED!");
        assertEquals(MessageState.INVALID_AUTH_TOKEN, youtube.validate(a).toOrchestration().getState());
    }
    @Test
    public void testConnectionWithNull(){
        SocialMediaInformation a =new SocialMediaInformation();
        a.setAuthToken("");
        assertEquals(MessageState.INVALID_AUTH_TOKEN, youtube.validate(a).toOrchestration().getState());
    }
}
