package sunlit.generics;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberCollection {
    public static <T extends Number> long countEvenNumbers(Collection<T> collection) {
        int count = 0;
        for (T number : collection) {
            if(number.intValue() % 2 == 0)
            {
                count++;
            }
        }
        return count;
    }

    public static <T> void swap(Collection<T> collection, int numberOne, int numberTwo) throws Exception{
        {
            try {
                Collections.swap((List<?>) collection, numberOne, numberTwo);
            } catch (NullPointerException e) {
                throw new Exception("Коллекция пуста!");
            } catch (IndexOutOfBoundsException e) {
                throw new Exception("Индекс вне границ коллекции!");
            }
        }
    }

}
