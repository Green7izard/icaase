package nl.dare2date.matching.orchestration;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Created by Bas on 21-10-2015.
 */
public class BasicObjectMessage implements ObjectMessage, Serializable {
    private Serializable object;
    private String id;
    private long timestamp;
    private String correlationId;
    private Destination replyTo;
    private Destination destination;
    private int deliveryMode;
    private boolean redelivered;
    private int priority;
    private long expiration;
    private String jmsType;

    public BasicObjectMessage(Serializable payload) {
        object=payload;
    }

    @Override
    public void setObject(Serializable object) throws JMSException {
        this.object=object;
    }

    @Override
    public Serializable getObject() throws JMSException {
        return object;
    }

    @Override
    public String getJMSMessageID() throws JMSException {
        return id;
    }

    @Override
    public void setJMSMessageID(String id) throws JMSException {
        this.id=id;
    }

    @Override
    public long getJMSTimestamp() throws JMSException {
        return timestamp;
    }

    @Override
    public void setJMSTimestamp(long timestamp) throws JMSException {
        this.timestamp=timestamp;
    }

    @Override
    public byte[] getJMSCorrelationIDAsBytes() throws JMSException {
        return correlationId.getBytes();
    }

    @Override
    public void setJMSCorrelationIDAsBytes(byte[] correlationID) throws JMSException {
        correlationId= Arrays.toString(correlationID);
    }

    @Override
    public void setJMSCorrelationID(String correlationID) throws JMSException {
        correlationId=correlationID;
    }

    @Override
    public String getJMSCorrelationID() throws JMSException {
        return correlationId;
    }

    @Override
    public Destination getJMSReplyTo() throws JMSException {
        return replyTo;
    }

    @Override
    public void setJMSReplyTo(Destination replyTo) throws JMSException {
        this.replyTo =replyTo;
    }

    @Override
    public Destination getJMSDestination() throws JMSException {
        return destination;
    }

    @Override
    public void setJMSDestination(Destination destination) throws JMSException {
        this.destination = destination;
    }

    @Override
    public int getJMSDeliveryMode() throws JMSException {
        return deliveryMode;
    }

    @Override
    public void setJMSDeliveryMode(int deliveryMode) throws JMSException {
        this.deliveryMode = deliveryMode;
    }

    @Override
    public boolean getJMSRedelivered() throws JMSException {
        return redelivered;
    }

    @Override
    public void setJMSRedelivered(boolean redelivered) throws JMSException {
        this.redelivered = redelivered;
    }

    @Override
    public String getJMSType() throws JMSException {
        return jmsType;
    }

    @Override
    public void setJMSType(String type) throws JMSException {
        this.jmsType=type;
    }

    @Override
    public long getJMSExpiration() throws JMSException {
        return expiration;
    }

    @Override
    public void setJMSExpiration(long expiration) throws JMSException {
        this.expiration = expiration;
    }

    @Override
    public int getJMSPriority() throws JMSException {
        return priority;
    }

    @Override
    public void setJMSPriority(int priority) throws JMSException {
        this.priority = priority;
    }

    @Override
    public void clearProperties() throws JMSException {

    }

    @Override
    public boolean propertyExists(String name) throws JMSException {
        return false;
    }

    @Override
    public boolean getBooleanProperty(String name) throws JMSException {
        return false;
    }

    @Override
    public byte getByteProperty(String name) throws JMSException {
        return 0;
    }

    @Override
    public short getShortProperty(String name) throws JMSException {
        return 0;
    }

    @Override
    public int getIntProperty(String name) throws JMSException {
        return 0;
    }

    @Override
    public long getLongProperty(String name) throws JMSException {
        return 0;
    }

    @Override
    public float getFloatProperty(String name) throws JMSException {
        return 0;
    }

    @Override
    public double getDoubleProperty(String name) throws JMSException {
        return 0;
    }

    @Override
    public String getStringProperty(String name) throws JMSException {
        return null;
    }

    @Override
    public Object getObjectProperty(String name) throws JMSException {
        return null;
    }

    @Override
    public Enumeration getPropertyNames() throws JMSException {
        return new Enumeration() {
            @Override
            public boolean hasMoreElements() {
                return false;
            }

            @Override
            public Object nextElement() {
                return null;
            }
        };
    }

    @Override
    public void setBooleanProperty(String name, boolean value) throws JMSException {

    }

    @Override
    public void setByteProperty(String name, byte value) throws JMSException {

    }

    @Override
    public void setShortProperty(String name, short value) throws JMSException {

    }

    @Override
    public void setIntProperty(String name, int value) throws JMSException {

    }

    @Override
    public void setLongProperty(String name, long value) throws JMSException {

    }

    @Override
    public void setFloatProperty(String name, float value) throws JMSException {

    }

    @Override
    public void setDoubleProperty(String name, double value) throws JMSException {

    }

    @Override
    public void setStringProperty(String name, String value) throws JMSException {

    }

    @Override
    public void setObjectProperty(String name, Object value) throws JMSException {

    }

    @Override
    public void acknowledge() throws JMSException {

    }

    @Override
    public void clearBody() throws JMSException {

    }
}
