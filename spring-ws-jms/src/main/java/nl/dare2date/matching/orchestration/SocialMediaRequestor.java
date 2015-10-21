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
    private String correlationID;

    public SocialMediaRequestor(Connection connection) throws NamingException, JMSException {
        super(connection, "matching", "matchingresponse", "errorque");
    }

    @Override
    public ObjectMessage getObjectMessage() {
        if(payload==null) {
            return null;
        }
        else{
            BasicObjectMessage message =new BasicObjectMessage(payload);
            try {
                message.setJMSCorrelationID(this.correlationID);
            } catch (JMSException e) {
                e.printStackTrace();
            }
            return message;
        }

    }

    @Override
    public Serializable getResponse() {
        try {
            return this.getReplyMessage().getObject();
        } catch (JMSException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setPayload(ConnectSocialMediaRequest payload) {
        this.payload = payload;
    }

    public void setCorrelationID(String correlationID) {
        this.correlationID = correlationID;
    }
}
