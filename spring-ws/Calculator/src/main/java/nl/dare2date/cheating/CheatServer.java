package nl.dare2date.cheating;


import nl.dare2date.matching.interests.socialMediaConnection.YouTubeConnector;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Bas on 11-10-2015.
 */
public class CheatServer extends HttpServletBean {

    private static final String URL = "http://localhost:8080/cheating/";
    private static final String youtubePart= "youtube/v3/";
    private static final String YOUTUBEURL = URL+youtubePart;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        if (req.getRequestURI().contains("activate")) {

            activateCheatMode(resp);
            return;
        }
        if(req.getRequestURI().contains(youtubePart))
        {
            reactToYoutube(req, resp);
            return;
        }


        resp.getWriter().append(req.getRequestURI());
    }

    private static final String subscription_reponse_header ="{\n"+
            " \"kind\": \"youtube#subscriptionListResponse\",\n"+
            " \"etag\": \"\\\"oyKLwABI4napfYXnGO8jtXfIsfc/nNANv_-Rx_Hv2X7UamEyYj4-xOo\\\"\",\n"+
            " \"pageInfo\": {\n"+
            "  \"totalResults\": 1,\n"+
            "  \"resultsPerPage\": 1\n"+
            " },\n"+
            " \"items\": [\n";

    private static final String subscription_reponse_body =
            "  {\n"+
            "\n"+
            "   \"kind\": \"youtube#subscription\",\n"+
            "   \"etag\": \"\\\"oyKLwABI4napfYXnGO8jtXfIsfc/gAN-Dxlej3KQfNfXLDgc7kGS0Rw\\\"\",\n"+
            "   \"id\": \"$id$\",\n"+
            "   \"snippet\": {\n"+
            "    \"publishedAt\": \"2013-11-22T15:26:22.000Z\",\n"+
            "    \"title\": \"$title$\",\n"+
            "    \"description\": \" TEST \" ,\n"+
            "    \"resourceId\": {\n"+
            "     \"kind\": \"youtube#channel\",\n"+
            "     \"channelId\": \"$id$\"\n"+
            "    },\n"+
            "    \"channelId\": \"$id$\",\n"+
            "    \"thumbnails\": {\n"+
            "     \"default\": {\n"+
            "      \"url\": \"https://yt3.ggpht.com/-rQpMPb0d9jE/AAAAAAAAAAI/AAAAAAAAAAA/DEvRDvjCJek/s88-c-k-no/photo.jpg\"\n"+
            "     },\n"+
            "     \"high\": {\n"+
            "      \"url\": \"https://yt3.ggpht.com/-rQpMPb0d9jE/AAAAAAAAAAI/AAAAAAAAAAA/DEvRDvjCJek/s240-c-k-no/photo.jpg\"\n"+
            "     }\n"+
            "    }\n"+
            "   }\n"+
            "  }\n";
    private final static String list_reponse_tail=
            " ]\n"+
            "}";

    private final static String category_response_header ="{\n" +
            " \"kind\": \"youtube#guideCategoryListResponse\",\n" +
            " \"etag\": \"\\\"oyKLwABI4napfYXnGO8jtXfIsfc/U2ueloPBf_jInVNe_VLdAekNKsc\\\"\",\n" +
            " \"items\": [";

    private final static String category_response_body = "{\n" +
            "  \"kind\": \"youtube#guideCategory\",\n" +
            "  \"etag\": etag,\n" +
            "  \"id\": string,\n" +
            "  \"snippet\": {\n" +
            "    \"title\": \"$title$\"\n" +
            "  }\n" +
            "}";



    private void reactToYoutube(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if(req.getRequestURI().toLowerCase().contains("oauth2"))
        {
            if(req.getParameter("access_token").toLowerCase().contains("test")) {
                resp.setStatus(200);
                resp.getWriter().append("Successfully Authenticated!");
            }
            else{
                resp.setStatus(403);
                resp.getWriter().append("FAILED");
            }
            return;
        }
        else if(req.getRequestURI().toLowerCase().contains("subscriptions"))
        {
            resp.getWriter().append(subscription_reponse_header);
            String user = req.getParameter("access_token");
            if(user.equalsIgnoreCase("test1"))
            {
                resp.getWriter().append(subscription_reponse_body.replaceAll("$id$", "channel1").replaceAll("$title$", "testing1"));
            }
            else if(user.equalsIgnoreCase("test2"))
            {
                resp.getWriter().append(subscription_reponse_body.replaceAll("$id$", "channel2").replaceAll("$title$", "testing2"));
            }
            if(user.equalsIgnoreCase("test3"))
            {
                resp.getWriter().append(subscription_reponse_body.replaceAll("$id$", "channel3").replaceAll("$title$", "testing3"));
            }
            resp.getWriter().append(list_reponse_tail);
            resp.setStatus(200);
            return;
        }
        else if(req.getRequestURI().toLowerCase().contains("guidecategories"))
        {
            resp.getWriter().append(category_response_header);
            String user = req.getParameter("id");
            if(user.equalsIgnoreCase("channel1"))
            {
                resp.getWriter().append(subscription_reponse_body.replaceAll("$title$", "Movies"));
            }
            else if(user.equalsIgnoreCase("test2"))
            {
                resp.getWriter().append(subscription_reponse_body.replaceAll("$title$", "Music"));
            }
            if(user.equalsIgnoreCase("test3"))
            {
                resp.getWriter().append(subscription_reponse_body.replaceAll("$title$", "test"));
            }

            resp.getWriter().append(list_reponse_tail);
            return;
        }
        else{
            resp.getWriter().append("Not a correct youtube request!");
            return;
        }
    }


    public void activateCheatMode(HttpServletResponse resp) throws IOException {
        try {
            final Field[] declaredFields = YouTubeConnector.class.getDeclaredFields();
            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            for(Field field:declaredFields)
            {
                System.out.println("Modifying: "+field.getName());
                field.setAccessible(true);
                modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            }
            YouTubeConnector conn = new YouTubeConnector();

            Field urlfield = YouTubeConnector.class.getDeclaredField("GOOGLE_URL");
            modifiersField.setInt(urlfield, Modifier.PUBLIC | Modifier.STATIC);
            urlfield.setAccessible(true);
            urlfield.set(null, YOUTUBEURL);
            resp.getWriter().append("Finished the Youtube URL: " + urlfield.get(conn) + "\n");

            Field validate = YouTubeConnector.class.getDeclaredField("VALIDATE_URL");
            modifiersField.setInt(validate, Modifier.PUBLIC|Modifier.STATIC);
            urlfield.setAccessible(true);
            validate.set(null, YOUTUBEURL + "oauth2?access_token=" + YouTubeConnector.AUTH_TOKEN_MARK);
            resp.getWriter().append("Finished the validate URL: " + validate.get(conn) + "\n");

            Field subscription = YouTubeConnector.class.getDeclaredField("GET_SUBSCRIPTIONS");
            modifiersField.setInt(subscription, Modifier.PUBLIC|Modifier.STATIC);
            subscription.setAccessible(true);
            subscription.set(null, YOUTUBEURL + "subscriptions?token=" + YouTubeConnector.AUTH_TOKEN_MARK);
            resp.getWriter().append("Finished the subscription request URL: " + subscription.get(conn) + "\n");

            Field category = YouTubeConnector.class.getDeclaredField("GET_CATEGORY");
            modifiersField.setInt(category, Modifier.PUBLIC | Modifier.STATIC);
            category.setAccessible(true);
            category.set(null, YOUTUBEURL + "guideCategories=" + YouTubeConnector.ID_MARK);
            resp.getWriter().append("Finished the category request: " + category.get(conn)+ "\n");

        } catch (NoSuchFieldException e) {
            resp.setStatus(404);
            resp.getWriter().append("No field: " + e.getMessage());
            return;
        } catch (IllegalAccessException e) {
            resp.setStatus(404);
            resp.getWriter().append("May not access: "+ e.getMessage());
            return;
        }


        resp.setStatus(200);
        resp.getWriter().append("Successfully Cheating!");
    }

}
