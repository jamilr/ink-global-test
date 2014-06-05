package com.berlinconverter.core;

import com.berlinconverter.util.IllegalTimeFormatException;

/**
 * @author JamiL Rzayev
 * @version June, 2014
 * BerlinConverter is an interface describing the protocol for any implementing class to develop an API for converting time to Berlin Clock Format
 */
public interface ClockConverter {

    /**
     * @param time - time parameter is a time given in the following format [HH:mm:ss]
     * @throws com.berlinconverter.util.IllegalTimeFormatException - method parse throws com.berlinconverter.util.IllegalTimeFormatException whenever the given time String object is of wrong format
     * @throws java.lang.NullPointerException - method parse throws NullPointerException in case provided time String object is null
     * */
     String convert(String time)
            throws IllegalTimeFormatException, NullPointerException;

    void setHourConverter(ClockPartConverter converter);

    void setMinuteConverter(ClockPartConverter converter);

    void setSecondConverter(ClockPartConverter converter);
}
