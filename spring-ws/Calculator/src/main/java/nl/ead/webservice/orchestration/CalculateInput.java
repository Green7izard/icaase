
package nl.ead.webservice.orchestration;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CalculateInput complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CalculateInput">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="paramlist" type="{http://www.han.nl/schemas/types}CalculateParameters"/>
 *         &lt;element name="operation" type="{http://www.han.nl/schemas/types}CalculateOperation"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CalculateInput", namespace = "http://www.han.nl/schemas/types", propOrder = {

})
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class CalculateInput {

    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected CalculateParameters paramlist;
    @XmlElement(namespace = "http://www.han.nl/schemas/types", required = true)
    @XmlSchemaType(name = "NCName")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected CalculateOperation operation;

    /**
     * Gets the value of the paramlist property.
     * 
     * @return
     *     possible object is
     *     {@link CalculateParameters }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public CalculateParameters getParamlist() {
        return paramlist;
    }

    /**
     * Sets the value of the paramlist property.
     * 
     * @param value
     *     allowed object is
     *     {@link CalculateParameters }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setParamlist(CalculateParameters value) {
        this.paramlist = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link CalculateOperation }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public CalculateOperation getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link CalculateOperation }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setOperation(CalculateOperation value) {
        this.operation = value;
    }

}
