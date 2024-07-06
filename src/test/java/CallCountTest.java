import Sunlit.unit_tests.FirstClass;
import Sunlit.unit_tests.SecondClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Before;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
public class CallCountTest
{
    @Mock
    private SecondClass exampleOne;
    @InjectMocks
    private FirstClass exampleTwo;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    public SecondClass setExampleOne() {
        return exampleOne;
    }
    public FirstClass setExampleTwo() {
        return exampleTwo;
    }

    @Test
    public void callCount()
    {
        exampleTwo.firstToSecond();
        Mockito.verify(exampleOne, Mockito.times(1)).secondToFirst();
    }
}
