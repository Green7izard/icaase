
package nl.dare2date.matching.orchestration;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="userID" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/>
 *         &lt;element name="socialMediaType" type="{http://www.dare2date.nl/types}SocialMediaType"/>
 *         &lt;element name="socialMediaPassword" type="{http://www.w3.org/2001/XMLSchema}NCName"/>
 *         &lt;element name="socialMediaUserName" type="{http://www.w3.org/2001/XMLSchema}NCName"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "connectSocialMediaRequest", namespace = "http://www.dare2date.nl/matching")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class ConnectSocialMediaRequest {

    @XmlElement(namespace = "http://www.dare2date.nl/matching")
    @XmlSchemaType(name = "unsignedInt")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected long userID;
    @XmlElement(namespace = "http://www.dare2date.nl/matching", required = true)
    @XmlSchemaType(name = "NCName")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected SocialMediaType socialMediaType;
    @XmlElement(namespace = "http://www.dare2date.nl/matching", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String socialMediaPassword;
    @XmlElement(namespace = "http://www.dare2date.nl/matching", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String socialMediaUserName;

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
     * Gets the value of the socialMediaType property.
     * 
     * @return
     *     possible object is
     *     {@link SocialMediaType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public SocialMediaType getSocialMediaType() {
        return socialMediaType;
    }

    /**
     * Sets the value of the socialMediaType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SocialMediaType }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setSocialMediaType(SocialMediaType value) {
        this.socialMediaType = value;
    }

    /**
     * Gets the value of the socialMediaPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getSocialMediaPassword() {
        return socialMediaPassword;
    }

    /**
     * Sets the value of the socialMediaPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setSocialMediaPassword(String value) {
        this.socialMediaPassword = value;
    }

    /**
     * Gets the value of the socialMediaUserName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getSocialMediaUserName() {
        return socialMediaUserName;
    }

    /**
     * Sets the value of the socialMediaUserName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setSocialMediaUserName(String value) {
        this.socialMediaUserName = value;
    }

}
