package Sunlit.reflection;

import Sunlit.annotations.DataContainer;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.testng.AssertJUnit.assertEquals;

public class ReflectionTest {

    @Test
    public void testAnnotatedClassCreated() throws NoSuchFieldException, IllegalAccessException {
        Reflection.annotatedClassCreated(7, 42, "testKey");

        Field keyField = DataContainer.class.getDeclaredField("key");
        Field valueField = DataContainer.class.getDeclaredField("value");

        keyField.setAccessible(true);
        valueField.setAccessible(true);

        DataContainer dataContainer = new DataContainer("testKey", 42);
        String actualKey = (String) keyField.get(dataContainer);
        int actualValue = valueField.getInt(dataContainer);

        assertEquals("testKey", actualKey);
        assertEquals(42, actualValue);
    }
}
