import com.berlinconverter.core.HourConverter;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by jr on 6/4/2014.
 */
public class HourConverterTest {

    private static HourConverter converter;

    @BeforeClass
    public static void startUp() {
        converter = new HourConverter();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWithNegativeMinutes() {

        int hours = -4;
        converter.convert(hours);
    }

    @Test
    public void testWithZeroMinutes() {

        int hours = 0;
        char[] output = converter.convert(hours);
        assertEquals("OOOO OOOO", new String(output));
    }

    @Test
    public void testWithOneMinute() {

        int hours = 1;
        char[] output = converter.convert(hours);
        assertEquals("OOOO ROOO", new String(output));
    }

    @Test
    public void testHoursMultiplierOfFive() {

        int hours = 20;
        char[] output = converter.convert(hours);
        assertEquals("RRRR OOOO", new String(output));
    }

    @Test
    public void testHours() {

        int hours = 23;
        char[] output = converter.convert(hours);
        assertEquals("RRRR RRRO", new String(output));
    }
}
