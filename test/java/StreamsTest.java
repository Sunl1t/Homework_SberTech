import Sunlit.streams.StreamContainer;
import Sunlit.streams.Streams;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamsTest {

    @Test
    public void testBinaryString() {
        String binaryString = "1001010110";

        boolean result = binaryString.chars().mapToObj(ch -> ch == '1').reduce(Boolean::logicalAnd).orElse(false);

        assertEquals(false, result);
    }

    @Test
    void testMapStream() {
        Map<String, List<StreamContainer>> map = new HashMap<>();

        List<StreamContainer> result = map.values().stream().flatMap(List::stream).toList();

        assertEquals(0, result.size());
    }

    @Test
    void testStringStream() {
        Stream<String> stringStream = Stream.of("1", "9", "8", "7");

        Map<Long, String> map = stringStream.map(s -> new StreamContainer(s, new Random().nextLong()))
                .collect(Collectors.toMap(StreamContainer::getCount, StreamContainer::getName));

        assertEquals(4, map.size());
    }

    @Test
    public void testStreamOperation() {
        IntStream intStream = IntStream.of(14,31,18,10,27);

        IntStream sortedStream = intStream.filter(x -> x > 9 && x < 100).sorted();

        double average = sortedStream.average().orElse(0);

        assertEquals(20.0, average);
    }
    @Test
    void calculateBooleanFromString() {
        Assertions.assertThat(new Streams().calculateBooleanFromString("1111111")).isEqualTo(true);

        Assertions.assertThat(new Streams().calculateBooleanFromString("1110111")).isEqualTo(false);

        Assertions.assertThat(new Streams().calculateBooleanFromString("0000000")).isEqualTo(false);

        Assertions.assertThat(new Streams().calculateBooleanFromString("")).isEqualTo(false);
    }

    @Test
    void intStreamWork() {
        Streams streamJob = Mockito.mock(Streams.class, Mockito.CALLS_REAL_METHODS);

        streamJob.intStream();

        Mockito.verify(streamJob, Mockito.times(1)).intStream();
    }

    @Test
    void stringStreamWork() {
        Streams streamJob = Mockito.mock(Streams.class, Mockito.CALLS_REAL_METHODS);

        streamJob.stringStream();

        Mockito.verify(streamJob, Mockito.times(1)).stringStream();
    }

    @Test
    void mapStreamWork() {
        Streams streamJob = Mockito.mock(Streams.class, Mockito.CALLS_REAL_METHODS);
        streamJob.mapStream();
        Mockito.verify(streamJob, Mockito.times(1)).mapStream();
    }
}
