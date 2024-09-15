import com.example.Cat;
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
public class CatTest {
    @Mock
    Feline felineMock;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(felineMock);
    }

    @Test
    public void getSoundOkTest() throws Exception {
        String expectedSound = "Мяу";
        assertEquals(expectedSound, cat.getSound());
    }
    @Test
    public void getFoodTest()throws  Exception{
        List<String> expectedFood = Arrays.asList("Мясо", "Птица");
        when(felineMock.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }
}