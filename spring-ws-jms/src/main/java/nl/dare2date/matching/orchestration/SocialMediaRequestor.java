package nl.dare2date.matching.orchestration;

import nl.han.dare2date.service.jms.util.Requestor;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.naming.NamingException;
import java.io.Serializable;
import java.util.Enumeration;

/**
 * Created by Bas on 21-10-2015.
 */
public class SocialMediaRequestor extends Requestor {

    private ConnectSocialMediaRequest payload;

    public SocialMediaRequestor(Connection connection) throws NamingException, JMSException {
        super(connection, "matching", "matching", "errorque");
    }

    @Override
    public ObjectMessage getObjectMessage() {
        if(payload==null) {
            return null;
        }
        else{
            return new BasicObjectMessage(payload);
        }

    }

    @Override
    public Serializable getResponse() {
        return null;
    }

    public void setPayload(ConnectSocialMediaRequest payload) {
        this.payload = payload;
    }
}
