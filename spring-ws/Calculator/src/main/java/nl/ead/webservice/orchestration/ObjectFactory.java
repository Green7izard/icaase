
package nl.ead.webservice.orchestration;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nl.ead.webservice.orchestration package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.ead.webservice.orchestration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CalculateRequest }
     * 
     */
    public CalculateRequest createCalculateRequest() {
        return new CalculateRequest();
    }

    /**
     * Create an instance of {@link CalculateInput }
     * 
     */
    public CalculateInput createCalculateInput() {
        return new CalculateInput();
    }

    /**
     * Create an instance of {@link CalculateResponse }
     * 
     */
    public CalculateResponse createCalculateResponse() {
        return new CalculateResponse();
    }

    /**
     * Create an instance of {@link CalculateResult }
     * 
     */
    public CalculateResult createCalculateResult() {
        return new CalculateResult();
    }

    /**
     * Create an instance of {@link CalculateParameters }
     * 
     */
    public CalculateParameters createCalculateParameters() {
        return new CalculateParameters();
    }

}