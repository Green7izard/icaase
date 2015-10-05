package nl.ead.webservice.services;

import nl.ead.webservice.*;
import nl.ead.webservice.dao.CalculationDao;
import nl.ead.webservice.model.Calculation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CalculatorEndpointTest {

    private class TempCalculationDao extends CalculationDao{
        @Override
        public void save(Calculation calculation) {
            //DO NOTHING AT ALL
        }
    }

    private CalculatorEndpoint calculatorEndpoint;

    private IMoviePrinter moviePrinter;

    @Before
    public void setUp() throws Exception {
         moviePrinter = Mockito.mock(IMoviePrinter.class);

        // moviePrinter is a mock, tempCalculationDao is a stub
        calculatorEndpoint = new CalculatorEndpoint(moviePrinter, new TempCalculationDao());
    }


    @Test
    public void addingOneAndTwoResultsInThree() throws Exception {
        CalculateRequest calculateRequest = new CalculateRequest();
        calculateRequest.setInput(new CalculateInput(){
            {
                setOperation(CalculateOperation.ADD);
                CalculateParameters calculateParameters = new CalculateParameters();
                calculateParameters.getParam().add(1);
                calculateParameters.getParam().add(2);
                setParamlist(calculateParameters);
            }
        });

        assertEquals(3, calculatorEndpoint.calculateSumForName(calculateRequest).getResult().getValue());

        Mockito.verify(moviePrinter).printMovieDetails(Matchers.eq("Bond"));

    }
}