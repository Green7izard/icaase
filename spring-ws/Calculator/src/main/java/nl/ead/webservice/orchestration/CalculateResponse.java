
package nl.ead.webservice.orchestration;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="result" type="{http://www.han.nl/schemas/types}CalculateResult"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "result"
})
@XmlRootElement(name = "CalculateResponse", namespace = "http://www.han.nl/schemas/messages")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class CalculateResponse {

    @XmlElement(namespace = "http://www.han.nl/schemas/messages", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected CalculateResult result;

    /**
     * Gets the value of the result property.
     * 
     * @return
     *     possible object is
     *     {@link CalculateResult }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public CalculateResult getResult() {
        return result;
    }

    /**
     * Sets the value of the result property.
     * 
     * @param value
     *     allowed object is
     *     {@link CalculateResult }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setResult(CalculateResult value) {
        this.result = value;
    }

}
