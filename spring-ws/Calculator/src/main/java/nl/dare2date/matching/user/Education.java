package nl.dare2date.matching.user;

import nl.dare2date.matching.orchestration.Educations;

/**
 * Created by Bas on 5-10-2015.
 */
public enum Education {
    UNKNOWN(Educations.UNKNOWN),
    NOT_PUBLISHED(Educations.NOT_PUBLISHED),
    ELEMENTARY(Educations.ELEMENTARY),
    VMBO(Educations.VMBO),
    HAVO(Educations.HAVO),
    VWO(Educations.VWO),
    MBO(Educations.MBO),
    HBO(Educations.HBO),
    WO(Educations.WO);

    private nl.dare2date.matching.orchestration.Educations representation;

    Education(nl.dare2date.matching.orchestration.Educations representation) {
        this.representation = representation;
    }

    public static Education fromSoap(nl.dare2date.matching.orchestration.Educations type) {
        for (Education currentValue : values()) {
            if (currentValue.representation.equals(type)) {
                return currentValue;
            }
        }
        return UNKNOWN;
    }

    public nl.dare2date.matching.orchestration.Educations toSoap() {
        return representation;
    }
}
