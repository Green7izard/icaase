
package nl.dare2date.matching.orchestration;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nl.dare2date.matching.orchestration package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.dare2date.matching.orchestration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMatchRequest }
     * 
     */
    public GetMatchRequest createGetMatchRequest() {
        return new GetMatchRequest();
    }

    /**
     * Create an instance of {@link ConnectSocialMediaRequest }
     * 
     */
    public ConnectSocialMediaRequest createConnectSocialMediaRequest() {
        return new ConnectSocialMediaRequest();
    }

    /**
     * Create an instance of {@link GetMatchResponse }
     * 
     */
    public GetMatchResponse createGetMatchResponse() {
        return new GetMatchResponse();
    }

    /**
     * Create an instance of {@link Match }
     * 
     */
    public Match createMatch() {
        return new Match();
    }

    /**
     * Create an instance of {@link ConnectSocialMediaResponse }
     * 
     */
    public ConnectSocialMediaResponse createConnectSocialMediaResponse() {
        return new ConnectSocialMediaResponse();
    }

    /**
     * Create an instance of {@link StatusMessage }
     * 
     */
    public StatusMessage createStatusMessage() {
        return new StatusMessage();
    }

}
