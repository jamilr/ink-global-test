package com.berlinconverter.core;

import com.berlinconverter.util.Constants;
import com.berlinconverter.util.IllegalTimeFormatException; /**
 * Created by jr on 6/3/2014.
 */

/**
 * @author Jamil Rzayev
 * @version June, 2014
 * com.berlinconverter.core.SimpleBerlinConverter implements com.berlinconverter.core.BerlinConverter interface providing a logic for converting time to Berlin Clock Format.
 * Time is supported in the following format [HH:mm:ss]
 *
 * */
public class SimpleBerlinConverter implements ClockConverter {

    private char[] hours;
    private char[] minutes;
    private char[] seconds;

    private ClockPartConverter hourConverter;
    private ClockPartConverter minuteConverter;
    private ClockPartConverter secondConverter;

    public SimpleBerlinConverter(){
        this.hourConverter = new HourConverter();
        this.minuteConverter = new MinuteConverter();
        this.secondConverter = new SecondConverter();
    }

    /**
     * Converts a specified time (@link time) to a Berlin Clock Format. The correct time format is  [HH:mm:ss]
     * @param time Time parameter is of String type. The time provided by a client to be converted to a Berlin Clock Format
     * @throws IllegalTimeFormatException - throws com.berlinconverter.util.IllegalTimeFormatException in case time parameter is of wrong time format.
     * @throws java.lang.NullPointerException - throws NullPointerException when given time parameter is null
     * @return returns an object of String type containing a time in Berlin Clock Format
     *
     * */
    @Override
    public String convert(String time)
            throws IllegalTimeFormatException, NullPointerException {

        Clock clock = parse(time);

        hours = hourConverter.convert(clock.getHours());
        minutes = minuteConverter.convert(clock.getMinutes());
        seconds = secondConverter.convert(clock.getSeconds());

        return new StringBuilder().append(seconds).append(Constants.SPACE)
                .append(hours).append(Constants.SPACE)
                .append(minutes).toString();
    }

    @Override
    public void setHourConverter(ClockPartConverter converter) {
        this.hourConverter = converter;
    }

    @Override
    public void setMinuteConverter(ClockPartConverter converter) {
        this.minuteConverter = converter;
    }

    @Override
    public void setSecondConverter(ClockPartConverter converter) {
        this.secondConverter = converter;
    }

    /**
     * Parses the time to verify that time is in correct time format [HH:mm:ss]
     * @throws IllegalTimeFormatException -  throws com.berlinconverter.util.IllegalTimeFormatException whenever the given time String object is of wrong format
     * @throws java.lang.NullPointerException - throws NullPointerException in case provided time String object is null
     *
     * */
    private Clock parse(String time)
            throws IllegalTimeFormatException, NullPointerException {

        if (time == null)
            throw new NullPointerException("Time is null");

        if (!time.matches(Constants.DATE_FORMAT))
            throw new IllegalTimeFormatException("Wrong date format provided");

        Clock clock = new Clock();

        String clockParts[]  = time.split(":");

        int hours = Integer.parseInt(clockParts[0]);
        int minutes = Integer.parseInt(clockParts[1]);
        int seconds = Integer.parseInt(clockParts[2]);

        if (hours > 24 || minutes > 60 || seconds > 60)
            throw new IllegalTimeFormatException("Time is not in a correct format");

        clock.setHours(hours);
        clock.setMinutes(minutes);
        clock.setSeconds(seconds);

        return clock;
    }
}
