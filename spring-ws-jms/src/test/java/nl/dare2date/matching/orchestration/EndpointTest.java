package nl.dare2date.matching.orchestration;

import nl.dare2date.matching.interests.InterestManager;
import nl.dare2date.matching.matching.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Matchers;
import org.mockito.Mockito;

import javax.jms.*;
import javax.naming.NamingException;


/**
 * Created by Bas on 5-10-2015.
 */
public class EndpointTest {

    MatcherEndpoint endpoint;
    Matcher matcher;
    ConnectionFactory factory;
    Connection conn;
    Session ses;
    MessageProducer producer;
    MessageConsumer consumer;

    /**
     * Prepare some steps before
     */
    @Before
    public void setUp() throws NamingException, JMSException {
        //Mock the matcher so that it does nothing
        matcher = Mockito.mock(Matcher.class);
        factory = Mockito.mock(ConnectionFactory.class);
        conn=Mockito.mock(Connection.class);
        ses = Mockito.mock(Session.class);
        Mockito.when(factory.createConnection()).thenReturn(conn);
        Mockito.when(conn.createSession(Matchers.anyBoolean(), Matchers.anyInt())).thenReturn(ses);

        producer = Mockito.mock(MessageProducer.class);
        Mockito.when(ses.createProducer((Destination) Matchers.any())).thenReturn(producer);
        consumer = Mockito.mock(MessageConsumer.class);
        Mockito.when(ses.createConsumer((Destination)Matchers.any())).thenReturn(consumer);
        //Create the endpoint with the mocks
        endpoint = new MatcherEndpoint(matcher, factory);

    }

    /**
     * test that the connectSocialMedia function gets delegated properly
     */
    @Test
    public void testConnectSocialMediaConnect() throws JMSException {
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
        StatusMessage status = new StatusMessage();
        status.setMessage(message);
        status.setState(state);
        Mockito.when(consumer.receive()).thenReturn(new BasicObjectMessage(status));


        //Do the fucntion we want to test
        ConnectSocialMediaResponse response = endpoint.connectSocialMedia(request);
        // Verify the interaction with out interestmanager mock
        //Mockito.verify(interestManager).connectSocialMedia(Matchers.eq(userId), Matchers.eq(nl.dare2date.matching.interests.socialMediaConnection.SocialMediaType.fromOrchestration(type)), Matchers.eq(password));

        ArgumentCaptor<BasicObjectMessage> argument = ArgumentCaptor.forClass(BasicObjectMessage.class);
        Mockito.verify(producer, Mockito.times(2)).send(argument.capture());
        Assert.assertEquals(request, argument.getAllValues().get(0).getObject());
        Assert.assertTrue(argument.getAllValues().get(0).getJMSCorrelationID().contains("User:5|For:FACE_BOOK|Time:"));

        //Check the response
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getResult());
        Assert.assertEquals(message, response.getResult().getMessage());
        Assert.assertEquals(state, response.getResult().getState());
    }

}
