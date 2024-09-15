import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


public class FelineTest {
    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test
    public void getFamilyTest() throws Exception {
        String expectedFamily = "Кошачьи";
        assertEquals(expectedFamily, feline.getFamily());
    }

    @Test
    public void getKittensDefaultTest() throws Exception {
        int expectedKittens = 1;
        assertEquals(expectedKittens, feline.getKittens());

    }

    @Test
    public void getKittensWithParametersTest() throws Exception {
        int kittenCounts = 3;
        assertEquals(kittenCounts, feline.getKittens(kittenCounts));
    }
}
