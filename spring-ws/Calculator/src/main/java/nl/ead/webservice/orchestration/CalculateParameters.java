
package nl.ead.webservice.orchestration;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CalculateParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CalculateParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="param" type="{http://www.w3.org/2001/XMLSchema}int" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalculateParameters", namespace = "http://www.han.nl/schemas/types", propOrder = {
    "param"
})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class CalculateParameters {

    @XmlElement(namespace = "http://www.han.nl/schemas/types", type = Integer.class)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected List<Integer> param;

    /**
     * Gets the value of the param property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the param property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParam().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Integer }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public List<Integer> getParam() {
        if (param == null) {
            param = new ArrayList<Integer>();
        }
        return this.param;
    }

}
