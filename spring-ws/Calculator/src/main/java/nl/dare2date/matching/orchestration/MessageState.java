
package nl.dare2date.matching.orchestration;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MessageState.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MessageState">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NCName">
 *     &lt;enumeration value="succeeded"/>
 *     &lt;enumeration value="timeOut"/>
 *     &lt;enumeration value="databaseError"/>
 *     &lt;enumeration value="invalidUserPass"/>
 *     &lt;enumeration value="otherProblem"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MessageState", namespace = "http://www.dare2date.nl/types")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum MessageState {

    @XmlEnumValue("succeeded")
    SUCCEEDED("succeeded"),
    @XmlEnumValue("timeOut")
    TIME_OUT("timeOut"),
    @XmlEnumValue("databaseError")
    DATABASE_ERROR("databaseError"),
    @XmlEnumValue("invalidUserPass")
    INVALID_USER_PASS("invalidUserPass"),
    @XmlEnumValue("otherProblem")
    OTHER_PROBLEM("otherProblem");
    private final String value;

    MessageState(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MessageState fromValue(String v) {
        for (MessageState c: MessageState.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
