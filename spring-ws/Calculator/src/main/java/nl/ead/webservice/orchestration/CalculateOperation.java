
package nl.ead.webservice.orchestration;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CalculateOperation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CalculateOperation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NCName">
 *     &lt;enumeration value="add"/>
 *     &lt;enumeration value="subtract"/>
 *     &lt;enumeration value="multiply"/>
 *     &lt;enumeration value="divide"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CalculateOperation", namespace = "http://www.han.nl/schemas/types")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:41:30+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum CalculateOperation {

    @XmlEnumValue("add")
    ADD("add"),
    @XmlEnumValue("subtract")
    SUBTRACT("subtract"),
    @XmlEnumValue("multiply")
    MULTIPLY("multiply"),
    @XmlEnumValue("divide")
    DIVIDE("divide");
    private final String value;

    CalculateOperation(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CalculateOperation fromValue(String v) {
        for (CalculateOperation c: CalculateOperation.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
