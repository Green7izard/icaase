package nl.dare2date.matching.interests.socialMediaConnection;

import nl.dare2date.matching.orchestration.MessageState;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Bas on 7-10-2015.
 */
public class FaceBookConnectorTest {
    private final FaceBookConnector facebook = new FaceBookConnector();

    //Test users
    private final static String TestUser = "CAAXnURiRkTMBAJ32zgZAZAlIysu2n7u6pN8LTMs074sodt4Tj3cZC2KOTq5OjB3kx5ZBCA6Noqkj2SKddeTKQrJY5Ot7ZBgkX5ZCZCcJB1ztINp50kvu5DWv3wdlfpWcLlZAAKZCZApsuMVEhrkDw8X0yUE4e5bZA2mQfDUuqqRwOvMf0RofL0RRZA1ZAK3gZApmE9SLb8ZBeUJnlHue5m2MREstB6g";
    private SocialMediaInformation info = new SocialMediaInformation();

    @Before
    public void setUp(){
        info.setValidated(false);
    }

    @Test
    public void ValidateTest(){
        StatusMessage message;
        info.setAuthToken(TestUser);
        message = facebook.validate(info);
        assertEquals("If this test fails, the TestUser token should be refreshed!",MessageState.SUCCEEDED, message.toOrchestration().getState());
        assertTrue(info.isValidated());
    }


    @Test
    public void ValidateTestNull(){
        StatusMessage message;
        message = facebook.validate(null);
        assertEquals(MessageState.INVALID_AUTH_TOKEN, message.toOrchestration().getState());
        assertFalse(info.isValidated());
    }

    @Test
    public void ValidateTestNull2(){
        StatusMessage message;
        info.setAuthToken("");
        message = facebook.validate(info);
        assertEquals(MessageState.INVALID_AUTH_TOKEN, message.toOrchestration().getState());
        assertFalse(info.isValidated());
    }

    @Test
    public void ValidateTestNonsense(){
        StatusMessage message;
        info.setAuthToken("ThisAintGonnaWork");
        message = facebook.validate(info);
        assertNotEquals(MessageState.SUCCEEDED, message.toOrchestration().getState());
        assertFalse(info.isValidated());
    }
}
