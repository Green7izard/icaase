package nl.dare2date.matching.user;

/**
 * Created by Bas on 5-10-2015.
 */
public enum Gender {
    MALE(nl.dare2date.matching.orchestration.Gender.MALE),
    FEMALE(nl.dare2date.matching.orchestration.Gender.FEMALE),
    UNKNOWN(nl.dare2date.matching.orchestration.Gender.UNKNOWN),
    NOT_PUBLISHED(nl.dare2date.matching.orchestration.Gender.NOT_PUBLISHED);

    private nl.dare2date.matching.orchestration.Gender representation;

    Gender(nl.dare2date.matching.orchestration.Gender representation) {
        this.representation = representation;
    }

    public static Gender fromSoap(nl.dare2date.matching.orchestration.Gender type) {
        for (Gender currentValue : values()) {
            if (currentValue.representation.equals(type)) {
                return currentValue;
            }
        }
        return null;
    }

    public nl.dare2date.matching.orchestration.Gender toSoap() {
        return representation;
    }
}
