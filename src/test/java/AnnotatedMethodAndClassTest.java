import Sunlit.annotations.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


@ExtendWith(MockitoExtension.class)
public class AnnotatedMethodAndClassTest {


    private AnnotatedMethodAndClass annotatedMethodAndClass;

    @BeforeEach
    void setUp() {
        annotatedMethodAndClass = new AnnotatedMethodAndClass();
    }
    @Test
    void dataContainerProcessNullTest() {
        AnnotatedMethodAndClass instance = new AnnotatedMethodAndClass();
        Assertions.assertThatThrownBy(() -> instance.dataContainerProcess(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void isEmptyDataContainerNullTest() {
        Assertions.assertThatThrownBy(() -> AnnotatedMethodAndClass.AnnotatedMethodAndSubclass.isEmptyDataContainer(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void isEmptyDataContainerTest() {
        DataContainer emptyData = new DataContainer("", 0);
        Assertions.assertThat(AnnotatedMethodAndClass.AnnotatedMethodAndSubclass.isEmptyDataContainer(emptyData)).isTrue();

        DataContainer nonEmptyData = new DataContainer("key", 1);
        Assertions.assertThat(AnnotatedMethodAndClass.AnnotatedMethodAndSubclass.isEmptyDataContainer(nonEmptyData)).isFalse();
    }

    @Test
    void testTimeAndPriorityOnMethod() throws NoSuchMethodException {
        TimeAndPriority annotation = annotatedMethodAndClass.getClass().getMethod("dataContainerProcess", DataContainer.class).getAnnotation(TimeAndPriority.class);
        assertThat(annotation).isNotNull();
        assertThat(annotation.hour()).isEqualTo(11);
        assertThat(annotation.priority()).isEqualTo(1);
        assertThat(annotation.description()).isEqualTo("The most important task");
    }

    @Test
    void testNullArgumentExceptionInDataContainerProcess() {
        assertThatThrownBy(() -> annotatedMethodAndClass.dataContainerProcess(null)).isInstanceOf(NullPointerException.class);
    }

    @Test
    void testDataContainerGettersAndSetters() {
        DataContainer dataContainer = new DataContainer("key", 42);
        assertThat(dataContainer.getKey()).isEqualTo("key");
        assertThat(dataContainer.getValue()).isEqualTo(42);

        dataContainer.setKey("newKey");
        dataContainer.setValue(24);
        assertThat(dataContainer.getKey()).isEqualTo("newKey");
        assertThat(dataContainer.getValue()).isEqualTo(24);
    }
    @Test
    void testDataContainerNoArgsConstructor() {
        DataContainer dataContainer = new DataContainer();
        assertThat(dataContainer.getKey()).isNull();
        assertThat(dataContainer.getValue()).isEqualTo(0);
    }
}
