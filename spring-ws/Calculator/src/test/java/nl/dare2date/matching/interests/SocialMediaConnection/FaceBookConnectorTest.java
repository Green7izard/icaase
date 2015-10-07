package nl.dare2date.matching.interests.SocialMediaConnection;

import junit.framework.Assert;
import nl.dare2date.matching.orchestration.MessageState;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Bas on 7-10-2015.
 */
public class FaceBookConnectorTest {
    private final FaceBookConnector facebook = new FaceBookConnector();

    //Test users
    private final static String Sharon_Alajdfbhibcje_Sharpesen = "CAAXnURiRkTMBAEuOJaUJZAAAlgbN06ftwjgqwZCuWy0t9MhfoiweiwxtdjpfZBE46BbCPUDlqSuF0w6R5UKoLdBoa0ZCjD8ZCXUzPjKHrHUhImp0FJbgYe1VwAxxjEVJb3BXCGluqYiZBZBZCIeJhfQ5f5Is0AZAQUcMD5qZBUi38SI3gecxjcX4kYT8aGhcrij6dtujpBOybc1q4jIKZBeQqfR";
    private final static String Joe_Alajdafdbfjce_Lauwitz = "CAAXnURiRkTMBAH9SK5QYcTT8ZBxkbBHKrlpfmqcsSuO81ZAZCvkQuvw3A2JTOege2BM3TBql1UDF8slPFLuNyAD2e8OWv1jZAiZCXBaSieYeUjIXZBNf4XWkEjZA1ZBONxcziUeveU7pDz5ZB0HotPmspEbMJvDoxJLjg71qMhcR2YDth9u3WM1H5AnZA0vTqPc7TLoK8SqUqVFICYZBQlPLbmL";
    private final static String Sandra_Alajciafagfja_Panditson = "CAAXnURiRkTMBAH9SK5QYcTT8ZBxkbBHKrlpfmqcsSuO81ZAZCvkQuvw3A2JTOege2BM3TBql1UDF8slPFLuNyAD2e8OWv1jZAiZCXBaSieYeUjIXZBNf4XWkEjZA1ZBONxcziUeveU7pDz5ZB0HotPmspEbMJvDoxJLjg71qMhcR2YDth9u3WM1H5AnZA0vTqPc7TLoK8SqUqVFICYZBQlPLbmL";
    private final static String Mark_Alajcfhfjhihi_Goldmanman = "CAAXnURiRkTMBAMIwLUwFYTRzmQPDDdu1w0XZAXZCPoZBKBZBZB9kkeRjIyzzFmmAwkmWjJMQNacVFZCYst6WL7ZCK1IaKBraF8wfZAPv8rivoD16I3uoRNnG72a62HpplWG48hAZAhhCrnsmD9xtJq5r6cCu0WmOIaKuuOjh9rWCOKkTEqdClvLlz6LWzLooJ0avKoxVri2APkRQibgWBoyaD";

    @Test
    public void ValidateTest(){
        StatusMessage message;
        message = facebook.validate(Sharon_Alajdfbhibcje_Sharpesen);
        assertEquals(MessageState.SUCCEEDED, message.toSoap().getState());
    }

    @Test
    public void ValidateTest2(){
        StatusMessage message;
        message = facebook.validate(Joe_Alajdafdbfjce_Lauwitz);
        assertEquals(MessageState.SUCCEEDED, message.toSoap().getState());
    }

    @Test
    public void ValidateTest3(){
        StatusMessage message;
        message = facebook.validate(Sandra_Alajciafagfja_Panditson);
        assertEquals(MessageState.SUCCEEDED, message.toSoap().getState());
    }

    @Test
    public void ValidateTest4(){
        StatusMessage message;
        message = facebook.validate(Mark_Alajcfhfjhihi_Goldmanman);
        assertEquals(MessageState.SUCCEEDED, message.toSoap().getState());
    }

    @Test
    public void ValidateTestNull(){
        StatusMessage message;
        message = facebook.validate(null);
        assertEquals(MessageState.INVALID_AUTH_TOKEN, message.toSoap().getState());
    }

    @Test
    public void ValidateTestNonsense(){
        StatusMessage message;
        message = facebook.validate("ThisAintGonnaWork");
        assertNotEquals(MessageState.SUCCEEDED, message.toSoap().getState());
    }
}
