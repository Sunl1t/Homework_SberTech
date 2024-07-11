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

        @Test
    public void callCount()
    {
        exampleOne = Mockito.mock(SecondClass.class);
        exampleTwo = Mockito.mock(FirstClass.class);
        exampleOne.secondToFirst();
        exampleTwo.firstToSecond();
        Mockito.when(exampleOne.secondToFirst()).thenReturn("General Kenobi!!");
        exampleTwo.firstToSecond();
        Mockito.verify(exampleOne, Mockito.times(1)).secondToFirst();
    }
}
