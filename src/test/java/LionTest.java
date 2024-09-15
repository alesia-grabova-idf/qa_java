import com.example.Lion;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline felineMock; // Мокаем зависимость Feline

    private Lion lion;

    @Before
    public void setUp() throws Exception {
        lion = new Lion("Самец", felineMock);
    }

    @Test
    public void getKittensLionTest() {
        int expectedKittenCount = 1;
        when(felineMock.getKittens()).thenReturn(expectedKittenCount);
        assertEquals(expectedKittenCount, lion.getKittens());
    }

    @Test
    public void getFoodLionTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Мясо", "Птица");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
    }
}