import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;

import Sunlit.unit_tests.FirstClass;
import Sunlit.unit_tests.SecondClass;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PrivateTest
{
    @Test
    public void testPrivateMethod() throws Exception {
        SecondClass secondClassMock = Mockito.mock(SecondClass.class);
        FirstClass instance = new FirstClass(secondClassMock);
        Method method = FirstClass.class.getDeclaredMethod("privateMethod");
        method.setAccessible(true);
        String result = (String) method.invoke(instance);
        assertEquals("Hello There", result);
    }
}
