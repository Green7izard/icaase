package nl.dare2date.matching.orchestration;

import nl.dare2date.matching.interests.InterestManager;
import nl.han.dare2date.service.jms.util.Replier;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;
import java.io.Serializable;

/**
 * Created by Bas on 21-10-2015.
 */
public class SocialMediaReplier extends Replier {

    private final InterestManager manager;

    private Serializable reply;

    @Autowired
    public SocialMediaReplier(InterestManager interestManager, Connection connection) throws NamingException, JMSException {
        super(connection, "matching", "errorque");
        manager=interestManager;
    }

    @Override
    public ObjectMessage getReplyMessage() {
        if(reply ==null)
        return null;
        else{
            return new BasicObjectMessage(reply);
        }
    }

    @Override
    public void handleMessage(Serializable contents) {
        if(contents instanceof ConnectSocialMediaRequest) {
            ConnectSocialMediaRequest matchRequest = (ConnectSocialMediaRequest) contents;
            reply= manager.connectSocialMedia(matchRequest.getUserID(),
                    //Point to the Version in the interests because that one is used for internal systems
                    nl.dare2date.matching.interests.socialMediaConnection.SocialMediaType.fromOrchestration(matchRequest.getSocialMediaType()),
                    matchRequest.getSocialMediaAuthenticationToken()).toOrchestration();
        }
    }
}
