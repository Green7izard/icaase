package nl.dare2date.matching.user;

/**
 * Created by Bas on 5-10-2015.
 */
public enum Religion {
    CHRISTIANITY(nl.dare2date.matching.orchestration.Religion.CHRISTIANITY),
    ISLAM(nl.dare2date.matching.orchestration.Religion.ISLAM),
    HINDUISM(nl.dare2date.matching.orchestration.Religion.HINDUISM),
    BUDDHISM(nl.dare2date.matching.orchestration.Religion.BUDDHISM),
    TAOISM(nl.dare2date.matching.orchestration.Religion.TAOISM),
    SHINTO(nl.dare2date.matching.orchestration.Religion.SHINTO),
    SIKHISM(nl.dare2date.matching.orchestration.Religion.SIKHISM),
    JUDAISM(nl.dare2date.matching.orchestration.Religion.JUDAISM),
    SHAMANISM(nl.dare2date.matching.orchestration.Religion.SHAMANISM),
    CAODAISM(nl.dare2date.matching.orchestration.Religion.CAODAISM),
    BAHA_I_FAITH(nl.dare2date.matching.orchestration.Religion.BAHA_I_FAITH),
    JAINISM(nl.dare2date.matching.orchestration.Religion.JAINISM),
    CHEONDOISM(nl.dare2date.matching.orchestration.Religion.CHEONDOISM),
    HOAHAOISM(nl.dare2date.matching.orchestration.Religion.HOAHAOISM),
    TENRIISM(nl.dare2date.matching.orchestration.Religion.TENRIISM),
    AGNOSTIC(nl.dare2date.matching.orchestration.Religion.AGNOSTIC),
    ATHEISM(nl.dare2date.matching.orchestration.Religion.ATHEISM),
    OTHER(nl.dare2date.matching.orchestration.Religion.OTHER),
    NOT_PUBLISHED(nl.dare2date.matching.orchestration.Religion.NOT_PUBLISHED);

    private nl.dare2date.matching.orchestration.Religion representation;

    Religion(nl.dare2date.matching.orchestration.Religion representation) {
        this.representation = representation;
    }

    public static Religion fromOrchestration(nl.dare2date.matching.orchestration.Religion type) {
        for (Religion currentValue : values()) {
            if (currentValue.representation.equals(type)) {
                return currentValue;
            }
        }
        return NOT_PUBLISHED;
    }

    public nl.dare2date.matching.orchestration.Religion toOrchestration() {
        return representation;
    }
}
