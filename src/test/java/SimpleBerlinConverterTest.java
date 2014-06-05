import com.berlinconverter.core.ClockConverter;
import com.berlinconverter.core.SimpleBerlinConverter;
import com.berlinconverter.util.IllegalTimeFormatException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;

/**
 * Created by jr on 6/3/2014.
 */

public class SimpleBerlinConverterTest {

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    private ClockConverter berlinConverter;

    @Before
    public void startUp() {

        berlinConverter = new SimpleBerlinConverter();

    }

    @Test(expected = NullPointerException.class)
    public void testConvertNull() throws IllegalTimeFormatException {

        String time = null;
        berlinConverter.convert(time);
    }

    @Test(expected = IllegalTimeFormatException.class)
    public void testConvertEmpty() throws IllegalTimeFormatException {

        String time = "";
        berlinConverter.convert(time);
    }

    @Test(expected = IllegalTimeFormatException.class)
    public void testConvertWrongTimeString() throws IllegalTimeFormatException  {

        String time = "345:321321:12";
        berlinConverter.convert(time);
    }

    @Test
    public void testConvertMidnight() throws IllegalTimeFormatException {

        String time = "00:00:00";
        String expected = "Y OOOO OOOO OOOOOOOOOOO OOOO";
        String berlinTime = berlinConverter.convert(time);
        assertEquals(expected, berlinTime);
    }

    @Test
    public void testConvertWithOddSeconds() throws IllegalTimeFormatException {

        String time = "12:33:09";
        String expected = "O RROO RROO YYRYYROOOOO YYYO";
        String berlinTime = berlinConverter.convert(time);
        assertEquals(expected, berlinTime);
    }

    @Test
    public void testConvertWithEvenSeconds() throws IllegalTimeFormatException {

        String time = "16:33:18";
        String expected = "Y RRRO ROOO YYRYYROOOOO YYYO";
        String berlinTime = berlinConverter.convert(time);
        assertEquals(expected, berlinTime);

    }
}
