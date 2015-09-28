
package nl.dare2date.matching.orchestration;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Match complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Match">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Match", namespace = "http://www.dare2date.nl/types", propOrder = {

})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class Match {

    @XmlElement(namespace = "http://www.dare2date.nl/types")
    @XmlSchemaType(name = "unsignedInt")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected long userID;
    @XmlElement(namespace = "http://www.dare2date.nl/types")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected int message;

    /**
     * Gets the value of the userID property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public long getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setUserID(long value) {
        this.userID = value;
    }

    /**
     * Gets the value of the message property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public int getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setMessage(int value) {
        this.message = value;
    }

}
