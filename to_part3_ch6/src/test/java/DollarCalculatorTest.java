import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DollarCalculatorTest {

    @Mock
    public MarketApi marketApi;

    @BeforeEach // test실행이전에
    public void init(){
        Mockito.lenient().when(marketApi.connect()).thenReturn(3000);
    }

    @Test
    public void testHello(){
        System.out.println("hello");
    }

    @Test
    public void dollarTest(){
        MarketApi marketApi = new MarketApi();
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Carculator carculator = new Carculator(dollarCalculator);
        System.out.println(carculator.sum(1,2));

        Assertions.assertEquals(22000, carculator.sum(10, 10));
        Assertions.assertEquals(0, carculator.minus(10, 10));
    }

    @Test
    public void mockTest(){
        DollarCalculator dollarCalculator = new DollarCalculator(marketApi);
        dollarCalculator.init();

        Carculator carculator = new Carculator(dollarCalculator);
        System.out.println(carculator.sum(10, 10));
        Assertions.assertEquals(60000, carculator.sum(10, 10));
        Assertions.assertEquals(0, carculator.minus(10, 10));
    }
}
