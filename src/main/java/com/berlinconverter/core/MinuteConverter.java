package com.berlinconverter.core;

import com.berlinconverter.util.Constants;

import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author Jamil Rzayev
 * @version June, 2014
 * MinuteConverter converts given minutes to Berlin Clock Format
 *
 */

public class MinuteConverter implements ClockPartConverter {

    /**
     * @param minutes minutes in the range from 0 to 60
     * @return minutes representation in Berlin Clock Format in a char array
     *
     * */
    @Override
    public char[] convert(int minutes)  {

        checkArgument(minutes >= 0, "negative minutes: %s", minutes);

        int quarterCount = minutes / Constants.QUARTER;
        int fiveMinCount = (minutes - (Constants.QUARTER*quarterCount)) / 5;
        int oneMinCount = minutes - (quarterCount*Constants.QUARTER) - (fiveMinCount*5);

        char[] firstPart = convertFirstPart(quarterCount, fiveMinCount);
        char[] secondPart = convertSecondPart(oneMinCount);

        return new StringBuilder().append(firstPart).append(Constants.SPACE).append(secondPart).toString().toCharArray();
    }

    private char[] convertFirstPart(int quarterCount, int fiveMinCount) {

        char[] minutesCharArray = new char[Constants.FIRST_MIN_SECTION_SIZE];

        int quarterSymbolCount = quarterCount*3;

        int i = 0;
        while (i < quarterSymbolCount) {
            minutesCharArray[i] = ((i+1) % 3 == 0) ? Constants.RED: Constants.YELLOW;
            i++;
        }

        Arrays.fill(minutesCharArray, i, i + fiveMinCount, Constants.YELLOW);

        i += fiveMinCount;

        Arrays.fill(minutesCharArray, i, Constants.FIRST_MIN_SECTION_SIZE, Constants.NULL);

        return minutesCharArray;
    }

    private char[] convertSecondPart(int minutes) {

        char[] minutesCharArray = new char[Constants.SCND_MIN_SECTION_SIZE];

        Arrays.fill(minutesCharArray, 0, minutes, Constants.YELLOW);
        Arrays.fill(minutesCharArray, minutes, Constants.SCND_MIN_SECTION_SIZE, Constants.NULL);

        return minutesCharArray;
    }
}
