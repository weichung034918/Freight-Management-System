package Constants;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

@XmlEnum
public enum AccessLevel {
    @XmlEnumValue("admin")
    admin("admin"),

    @XmlEnumValue("client")
    client("client"),

    @XmlEnumValue("customer")
    customer("customer");
    private String value;

    AccessLevel(String value) {
        this.value = value;
    }
}
