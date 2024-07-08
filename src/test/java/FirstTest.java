import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import Sunlit.unit_tests.FirstClass;
import Sunlit.unit_tests.SecondClass;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FirstTest
{

    public SecondClass second = mock(SecondClass.class);

    @Test
    public void checkMethodFirst()
    {
        FirstClass firstMock = Mockito.mock(FirstClass.class);
        Mockito.when(firstMock.firstToSecond()).thenReturn("Exception");
    }

    @Test
    public void testMethodWithException() throws Exception
    {
        doThrow(new UnsupportedOperationException("Exception")).when(second).methodThrowingException();
        assertThrows(UnsupportedOperationException.class, () -> second.methodThrowingException());
    }

}
