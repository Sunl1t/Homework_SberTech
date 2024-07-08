import Sunlit.generics.NumberCollection;
import Sunlit.generics.ServiceHandler;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GenericsTest {

    @Test
    void countEvenNumbersTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        long count = NumberCollection.countEvenNumbers(numbers);
        assertEquals(3, count);
    }

    @Test
    void swapElementsTest() {
        List<String> list = Arrays.asList("A", "B", "C", "D");
        try {
            NumberCollection.swap(list, 0, 2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(Arrays.asList("C", "B", "A", "D"), list);
    }

}
