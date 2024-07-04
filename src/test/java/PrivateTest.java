import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class PrivateTest
{
    @Test
    public void testPrivateMethod() throws Exception {
        FirstClass instance = new FirstClass();
        Method method = FirstClass.class.getDeclaredMethod("privateMethod");
        method.setAccessible(true);
        String result = (String) method.invoke(instance);
        assertEquals("Hello There", result);
    }
}
