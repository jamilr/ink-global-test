import com.berlinconverter.core.SecondConverter;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Jamil Rzayev
 * @version June, 2014
 *
 */

public class SecondConverterTest {

    private static SecondConverter converter;

    @BeforeClass
    public static void startUp() {
        converter = new SecondConverter();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testNegativeSeconds() {

        int seconds = -2;
        converter.convert(seconds);
    }

    @Test
    public void testZeroSeconds() {

        int seconds = 0;
        converter.convert(seconds);
    }

    @Test
    public void testOneSecond() {

        int seconds = 1;
        converter.convert(seconds);
    }

    @Test
    public void testOddSecond() {

        int seconds = 3;
        converter.convert(seconds);
    }

    @Test
    public void testEvenSecond() {

        int seconds = 18;
        converter.convert(seconds);
    }
}
