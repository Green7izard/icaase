package nl.dare2date.matching.interests.SocialMediaConnection;

/**
 * Created by Bas on 5-10-2015.
 */
public enum SocialMediaType {
    FACEBOOK(nl.dare2date.matching.orchestration.SocialMediaType.FACE_BOOK),
    YOUTUBE(nl.dare2date.matching.orchestration.SocialMediaType.YOU_TUBE),
    OTHER(null);

    private nl.dare2date.matching.orchestration.SocialMediaType representation;

    SocialMediaType(nl.dare2date.matching.orchestration.SocialMediaType representation){
        this.representation=representation;
    }

    public static SocialMediaType fromSoap(nl.dare2date.matching.orchestration.SocialMediaType type)
    {
        for(SocialMediaType currentValue : values()){
            if(currentValue.representation!=null&&currentValue.representation.equals(type))
            {
                return currentValue;
            }
        }
        return null;
    }

    public nl.dare2date.matching.orchestration.SocialMediaType toSoap(){
        return representation;
    }
}
