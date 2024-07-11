import sunlit.lambda.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class lambdaTest {
        @Test
        void testSoundTest() {
            LambdaMain testMain = Mockito.mock(LambdaMain.class);
            testMain.testSound();
            Mockito.spy();
            Mockito.verify(testMain).testSound();
        }
    }
