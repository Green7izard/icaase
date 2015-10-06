package nl.dare2date.matching.interests.SocialMediaConnection;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
import nl.dare2date.matching.interests.Interest;
import nl.dare2date.matching.orchestration.MessageState;

import java.util.List;

/**
 * Test users:
 * CAAXnURiRkTMBADQ8hDTrhzFl4MCrq0vQPnWOfyTt1Hq1t6YCvt4yvYGPDJtrDaHBZBwel9fyk2tihut8MsZCwrJqMsSEsEdbBhxS8PKpPyvPvgZCFuCCrCrl5jONTYtK1izkw3pGF0xlIHSO5ZCktsZCKeEfrXeT5Nc789MV0VhQfZCJyOgdB6yApWgZA6r8z8jpSgwnl1MlwZDZD  -- Sharon Alajdfbhibcje Sharpesen
 * CAAXnURiRkTMBAIKublmrOD5C0kZBsZBaJ42X0j1T5YT4F9hPPT74PdzTfSMfrQdOvkULOTgj8KAtZCab3pnLXn1ZCWmEwJn67zmEdmABkpunqp2mXKIGNYx60HBDsMfKu4is1ZB4gtITv8pa5DcpUirwPF63aEAvxpZCNwuxN707fg238CB32z2UBQgm6DZCx4ZBP5LdIOLMEwZDZD -- Joe Alajdafdbfjce Lauwitz
 * CAAXnURiRkTMBAJNcuZBVXcvrXapSOyhvNcqsmeJszLmuXPEjsMAZASSTgpbWAH7sNrs4ywqnYGsJcJBsN8VdM2eF0ifpiJQ0bf97rkGERZBaYUkYSBimVvjCZAJVdEvMKhFbh7Xdzewd9ZAS3gXkNuhjYJn0ZA5ZCdmRypPK1rZAxrJBzv54DsmDNL1cMqJG78Id67oUaqynPQZDZD -- Sandra Alajciafagfja Panditson
 * CAAXnURiRkTMBAKO9PjzZAkD8NYbsgkK3BTUIJQBtbZALCFGtDFzl5hAURGT5Yj3R0ZC60HXCm6LlnmPcY7JXaVPF10anVHkv58kbHL1nW8IZCsPaqKyUoed0VZB7inurS3ZCkRUBt4WWBYsZC8ePJSrlvQcWRBWgvKZCwoenkiJx1iGDZAUyfi783590NPAXidiS0Jqdo9yyFnAZDZD -- Mark Alajcfhfjhihi Goldmanman
 */

/**
 * Created by Bas on 6-10-2015.
 */
public class FaceBookConnector implements SocialMediaConnector {
    @Override
    public StatusMessage validate(String authToken) {
        //TODO
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId("1661710374113587", "20220f5ad0ecab259a29d07e5a873a51");
        facebook.setOAuthPermissions("public_profile, user_about_me");
        facebook.setOAuthAccessToken(new AccessToken(authToken, null));
        try {
            if (facebook.getOAuthAccessToken().getExpires() > 0) {
                //TODO store that shizzle
                return new StatusMessage(MessageState.SUCCEEDED, "Connected to FaceBook! All your info now belongs to us!");
            }
            else
            {
                return new StatusMessage(MessageState.OTHER_PROBLEM,"Token expired!, Please relog to your FaceBook!");
            }
        }
        catch(IllegalStateException e)
        {
            return new StatusMessage(MessageState.INVALID_USER_PASS, e.getMessage());
        }
    }

    @Override
    public List<Interest> getInterests(String authToken) {
        return null;
    }
}
