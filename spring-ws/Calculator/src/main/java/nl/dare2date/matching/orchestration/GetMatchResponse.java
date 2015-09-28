
package nl.dare2date.matching.orchestration;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="result" type="{http://www.dare2date.nl/types}Match" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlRootElement(name = "GetMatchResponse", namespace = "http://www.dare2date.nl/matching")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class GetMatchResponse {

    @XmlElement(namespace = "http://www.dare2date.nl/matching")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<Match> result;

    /**
     * Gets the value of the result property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the result property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Match }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<Match> getResult() {
        if (result == null) {
            result = new ArrayList<Match>();
        }
        return this.result;
    }

}
