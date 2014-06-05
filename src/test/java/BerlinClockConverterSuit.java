import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by jr on 6/5/2014.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({HourConverterTest.class, MinuteConverterTest.class,
        SecondConverterTest.class, SimpleBerlinConverterTest.class})
public class BerlinClockConverterSuit {

}
