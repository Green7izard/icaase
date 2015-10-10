package nl.dare2date.matching.interests.socialMediaConnection;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Like;
import facebook4j.auth.AccessToken;
import nl.dare2date.matching.interests.Interest;
import nl.dare2date.matching.interests.InterestType;
import nl.dare2date.matching.orchestration.MessageState;

import java.util.ArrayList;
import java.util.List;

/**
 * Connector for the facebook API
 * Uses Facebook4j
 */
public class FaceBookConnector implements SocialMediaConnector {

    //https://graph.facebook.com/oauth/access_token?client_id=1661710374113587&redirect_uri=http://localhost:8080&client_secret=20220f5ad0ecab259a29d07e5a873a51&code=public_profile user_about_me

    private static final String APP_ID = "1661710374113587";
    private static final String APP_SECRET = "20220f5ad0ecab259a29d07e5a873a51";

    @Override
    public StatusMessage validate(SocialMediaInformation info) {
        if (info == null || info.getAuthToken().isEmpty()) {
            return new StatusMessage(MessageState.INVALID_AUTH_TOKEN, "No token supplied!");
        }
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId(APP_ID, APP_SECRET);
        facebook.setOAuthPermissions("public_profile, user_about_me");
        facebook.setOAuthAccessToken(new AccessToken(info.getAuthToken()));
        try {
            if ((facebook.getOAuthAccessToken().getExpires() == null || facebook.getOAuthAccessToken().getExpires() > 0)
                    && facebook.users().getMe() != null) {
                info.setValidated(true);
                //Storage is not for us to execute
                return new StatusMessage(MessageState.SUCCEEDED, "Connected to FaceBook! All your info now belongs to us!");
            } else {
                info.setValidated(false);
                return new StatusMessage(MessageState.OTHER_PROBLEM, "Token expired!, Please relog to your FaceBook!");
            }
        } catch (IllegalStateException e) {
            info.setValidated(false);
            return new StatusMessage(MessageState.INVALID_AUTH_TOKEN, e.getMessage());
        } catch (FacebookException e) {
            info.setValidated(false);
            switch (e.getStatusCode()) {
                case 190:
                    return new StatusMessage(MessageState.INVALID_AUTH_TOKEN, e.getMessage());
                case 102:
                    return new StatusMessage(MessageState.AUTH_TOKEN_EXPIRED, e.getMessage());
                case 1:
                    return new StatusMessage(MessageState.TIME_OUT, "Could not reach FaceBook");
                case 2:
                    return new StatusMessage(MessageState.TIME_OUT, "Could not reach FaceBook");
                case 4:
                    return new StatusMessage(MessageState.OTHER_PROBLEM, e.getMessage());
                case 10:
                    return new StatusMessage(MessageState.AUTH_TOKEN_EXPIRED, e.getMessage());
                case 341:
                    return new StatusMessage(MessageState.OTHER_PROBLEM, "Dare2Date Facebook limit reached");
                case 467:
                    return new StatusMessage(MessageState.INVALID_AUTH_TOKEN, e.getMessage());
                case 400:
                    return new StatusMessage(MessageState.INVALID_AUTH_TOKEN, e.getMessage());
                default:
                    return new StatusMessage(MessageState.OTHER_PROBLEM, e.getMessage());
            }
        }
    }

    @Override
    public List<Interest> getInterests(SocialMediaInformation information) {
        if (information.isValidated()) {
            Facebook facebook = new FacebookFactory().getInstance();
            facebook.setOAuthAppId(APP_ID, APP_SECRET);
            facebook.setOAuthPermissions("public_profile, user_about_me");
            facebook.setOAuthAccessToken(new AccessToken(information.getAuthToken()));
            try {
                List<Interest> returnList = new ArrayList<Interest>(0);
                for (Like like : facebook.getUserLikes()) {
                    Interest newInterest = new Interest();
                    newInterest.setSource(SocialMediaType.FACEBOOK);
                    newInterest.setName(like.getName());
                    newInterest.setType(getCategory(like.getCategory()));
                }
                return returnList;
            } catch (FacebookException e) {
                information.setValidated(false);
                return new ArrayList<Interest>(0);
            }
        } else {
            return new ArrayList<Interest>(0);
        }
    }

    @Override
    public SocialMediaType getType() {
        return SocialMediaType.FACEBOOK;
    }

    /**
     * Turn a facebook category into a Dare2Date category
     * @param category the facebook category
     * @return a InterestType
     */
    private InterestType getCategory(String category) {
        switch (category) {
            case "Actor/director":
                return InterestType.MOVIE;
            case "Airport":
                return InterestType.TRAVEL;
            case "Album":
                return InterestType.MUSIC;
            case "Amateur sports team":
                return InterestType.SPORT;
            case "Animal":
                return InterestType.ANIMAL;
            case "Animal breed":
                return InterestType.ANIMAL;
            case "App":
                return InterestType.COMPUTERS;
            case "Artist":
                return InterestType.MUSIC;
            case "Arts / entertainment / nightlife":
                return InterestType.SOCIAL;
            case "Athlete":
                return InterestType.SPORT;
            case "Attractions / things to do":
                return InterestType.SOCIAL;
            case "Author":
                return InterestType.BOOK;
            case "Automobiles and parts":
                return InterestType.TINKERING;
            case "Automotive":
                return InterestType.TRANSPORTATION;
            case "Baby goods/kids goods":
                return InterestType.KIDS;
            case "Bar":
                return InterestType.SOCIAL;
            case "Book":
                return InterestType.BOOK;
            case "Book genre":
                return InterestType.BOOK;
            case "Book store":
                return InterestType.BOOK;
            case "Camera/photo":
                return InterestType.PHOTOGRAPHY;
            case "Cars":
                return InterestType.TRANSPORTATION;
            case "Cause":
                return InterestType.HUMANITARIAN;
            case "Chef":
                return InterestType.FOOD;
            case "Clothing":
                return InterestType.CLOTHING;
            case "Club":
                return InterestType.SOCIAL;
            case "Coach":
                return InterestType.SPORT;
            case "Color":
                return InterestType.COLOR;
            case "Comedian":
                return InterestType.THEATHER;
            case "Community":
                return InterestType.COMMUNITY;
            case "Community organization":
                return InterestType.COMMUNITY;
            case "Community/government":
                return InterestType.COMMUNITY;
            case "Computers":
                return InterestType.COMPUTERS;
            case "Computers / internet website":
                return InterestType.COMPUTERS;
            case "Computers / technology":
                return InterestType.COMPUTERS;
            case "Concert tour":
                return InterestType.MUSIC;
            case "Concert venue":
                return InterestType.MUSIC;
            case "Dancer":
                return InterestType.SPORT;
            case "Drink":
                return InterestType.FOOD;
            case "Electronics":
                return InterestType.TINKERING;
            case "Episode":
                return InterestType.TVSERIES;
            case "Food":
                return InterestType.FOOD;
            case "Food / beverages":
                return InterestType.FOOD;
            case "Food / grocery":
                return InterestType.FOOD;
            case "Games / toys":
                return InterestType.GAME;
            case "Government official":
                return InterestType.POLITICS;
            case "Government organization":
                return InterestType.POLITICS;
            case "Health / beauty":
                return InterestType.HEALTH;
            case "Health / medical / pharmaceuticals":
                return InterestType.HEALTH;
            case "Health / medical / pharmacy":
                return InterestType.HEALTH;
            case "Health / wellness website":
                return InterestType.HEALTH;
            case "Home / garden website":
                return InterestType.NATURE;
            case "Hotel":
                return InterestType.TRAVEL;
            case "Internet / software":
                return InterestType.COMPUTERS;
            case "Kitchen / cooking":
                return InterestType.FOOD;
            case "Library":
                return InterestType.BOOK;
            case "Local / travel website":
                return InterestType.TRAVEL;
            case "Magazine":
                return InterestType.BOOK;
            case "Media / news / publishing":
                return InterestType.BOOK;
            case "Monarch":
                return InterestType.POLITICS;
            case "Movie":
                return InterestType.MOVIE;
            case "Movie general":
                return InterestType.MOVIE;
            case "Movie genre":
                return InterestType.MOVIE;
            case "Movie theater":
                return InterestType.MOVIE;
            case "Movies / music":
                return InterestType.MUSIC;
            case "Museum / art gallery":
                return InterestType.ART;
            case "Music":
                return InterestType.MUSIC;
            case "Music award":
                return InterestType.MUSIC;
            case "Music chart":
                return InterestType.MUSIC;
            case "Music video":
                return InterestType.MUSIC;
            case "Musical genre":
                return InterestType.MUSIC;
            case "Musician / band":
                return InterestType.MUSIC;
            case "Neighborhood":
                return InterestType.COMMUNITY;
            case "Non - profit organization":
                return InterestType.HUMANITARIAN;
            case "Outdoor gear/sporting goods":
                return InterestType.SPORT;
            case "Patio / garden":
                return InterestType.NATURE;
            case "Pet services":
                return InterestType.ANIMAL;
            case "Pet supplies":
                return InterestType.ANIMAL;
            case "Political ideology":
                return InterestType.POLITICS;
            case "Political organization":
                return InterestType.POLITICS;
            case "Political party":
                return InterestType.POLITICS;
            case "Politician":
                return InterestType.POLITICS;
            case "Professional sports team":
                return InterestType.SPORT;
            case "Public places":
                return InterestType.SOCIAL;
            case "Publisher":
                return InterestType.BOOK;
            case "Radio station":
                return InterestType.MUSIC;
            case "Restaurant / cafe":
                return InterestType.SOCIAL;
            case "School sports team":
                return InterestType.SPORT;
            case "Society / culture website":
                return InterestType.COMMUNITY;
            case "Software":
                return InterestType.COMPUTERS;
            case "Song":
                return InterestType.MUSIC;
            case "Spas / beauty / personal care":
                return InterestType.HEALTH;
            case "Sport":
                return InterestType.SPORT;
            case "Sports league":
                return InterestType.SPORT;
            case "Sports venue":
                return InterestType.SPORT;
            case "Sports / recreation / activities":
                return InterestType.SPORT;
            case "Tours / sightseeing":
                return InterestType.TRAVEL;
            case "Tv":
                return InterestType.TVSERIES;
            case "Tv channel":
                return InterestType.TVSERIES;
            case "Tv genre":
                return InterestType.TVSERIES;
            case "Tv network":
                return InterestType.TVSERIES;
            case "Tv show":
                return InterestType.TVSERIES;
            case "Tv / movie award":
                return InterestType.TVSERIES;
            default:
                return InterestType.OTHER;
        }
    }


}
