package nl.dare2date.matching.interests.SocialMediaConnection;

import nl.dare2date.matching.interests.Interest;

import java.util.List;

/**
 * Created by Bas on 5-10-2015.
 */
public interface SocialMediaConnector {
    StatusMessage validate(SocialMediaInformation info);
    List<Interest> getInterests(SocialMediaInformation info);
}
