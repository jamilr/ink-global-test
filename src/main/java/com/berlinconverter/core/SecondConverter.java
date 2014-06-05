package com.berlinconverter.core;

import com.berlinconverter.util.Constants;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author Jamil Rzayev
 * @version June, 2014
 * SecondConverter converts given seconds to Berlin Clock Format
 *
 */

public class SecondConverter implements ClockPartConverter {

    /**
     * @param secs seconds in the range from 0 to 60
     * @return seconds representation in Berlin Clock Format in a char array
     *
     * */
    @Override
    public char[] convert(int secs)  {

        checkArgument( secs >= 0, "negative seconds: %s", secs);

        char[] seconds = new char[1];

        seconds[0]  = ((secs & 1) == 0) ? Constants.YELLOW : Constants.NULL;

        return seconds;
    }
}
