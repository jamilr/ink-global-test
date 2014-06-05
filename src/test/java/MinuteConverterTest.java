import com.berlinconverter.core.HourConverter;
import com.berlinconverter.core.MinuteConverter;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jr on 6/4/2014.
 */
public class MinuteConverterTest {

    private static MinuteConverter converter;

    @BeforeClass
    public static void startUp() {
        converter = new MinuteConverter();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWithNegativeMinutes() {

        int minutes = -4;
        converter.convert(minutes);
    }

    @Test
    public void testWithZeroMinutes() {

        int minutes = 0;
        char[] output = converter.convert(minutes);
        assertEquals("OOOOOOOOOOO OOOO", new String(output));
    }

    @Test
    public void testWithOneMinute() {

        int minutes = 1;
        char[] output = converter.convert(minutes);
        assertEquals("OOOOOOOOOOO YOOO", new String(output));


    }

    @Test
    public void testQuarterMinutes() {

        int minutes = 45;
        char[] output = converter.convert(minutes);
        assertEquals("YYRYYRYYROO OOOO", new String(output));
    }
}
