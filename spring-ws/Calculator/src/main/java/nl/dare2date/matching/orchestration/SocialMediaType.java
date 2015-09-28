
package nl.dare2date.matching.orchestration;

import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SocialMediaType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="SocialMediaType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NCName">
 *     &lt;enumeration value="FaceBook"/>
 *     &lt;enumeration value="YouTube"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SocialMediaType", namespace = "http://www.dare2date.nl/types")
@XmlEnum
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2015-09-28T10:49:21+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public enum SocialMediaType {

    @XmlEnumValue("FaceBook")
    FACE_BOOK("FaceBook"),
    @XmlEnumValue("YouTube")
    YOU_TUBE("YouTube");
    private final String value;

    SocialMediaType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SocialMediaType fromValue(String v) {
        for (SocialMediaType c: SocialMediaType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
