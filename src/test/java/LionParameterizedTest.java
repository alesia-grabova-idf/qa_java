import com.example.Lion;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    @Mock
    Feline felineMock; // Мокаем зависимость Feline

    private Lion lion;

    private String sex;
    private boolean expectedMane;
    private boolean shouldThrowException;

    public LionParameterizedTest(String sex, boolean expectedMane, boolean shouldThrowException) {
        this.sex = sex;
        this.expectedMane = expectedMane;
        this.shouldThrowException = shouldThrowException;
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        if (!shouldThrowException) {
            lion = new Lion(sex, felineMock);
        }
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true, false},
                {"Самка", false, false},
                {"Кто-то", false, true} // Это значение используется для проверки исключения
        });
    }

    @Test
    public void lionManeTest() {
        if (!shouldThrowException) {
            assertEquals(expectedMane, lion.doesHaveMane());
        }
    }

    @Test
    public void lionConstructorThrowsExceptionForInvalidSex() {
        if (shouldThrowException) {
            // Проверяем, что исключение выбрасывается для недопустимого значения пола
            Exception exception = assertThrows(Exception.class, () -> {
                new Lion(sex, felineMock);
            });
            assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
        }
    }
}
