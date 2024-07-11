package sunlit.streams;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Streams {
    public void intStream() {
        IntStream intStream = IntStream.of(85,55,92,74,14,15,78,11,19,34);

        intStream = intStream.filter(x -> x > 9 && x < 100).sorted();

        double average = intStream.average().orElse(0);

        System.out.println("Среднее значение: " + average);
    }

    public void stringStream() {
        Stream<String> strStream = Stream.of("John", "Jane", "Doe");
        Random rand = new Random();
        java.util.stream.Stream<StreamContainer> newStream = strStream.map(x -> {
            StreamContainer container = new StreamContainer(x, rand.nextInt(101));

            System.out.println(container);

            return container;
        });

    }

    public boolean calculateBooleanFromString(String binaryString) {
        return binaryString.chars().mapToObj(x -> x == '1').reduce(Boolean::logicalAnd).orElse(false);
        
    }


    public void mapStream() {
        Map<String, List<StreamContainer>> map = new HashMap<>();

        List<StreamContainer> result = map.values().stream().flatMap(List::stream).collect(Collectors.toList());

        long count = result.stream().count();

        System.out.println("Count: " + count);
    }
}
