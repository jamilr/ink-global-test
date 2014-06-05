package com.berlinconverter.core;

import com.berlinconverter.util.Constants;

import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * @author Jamil Rzayev
 * @version June, 2014
 * HourConverter converts given hours to Berlin Clock Format
 *
 */

public class HourConverter implements ClockPartConverter {

    /**
     * @param intHours hours in the range from 0 to 60
     * @return hours representation in Berlin Clock Format in a char array
     *
     * */
    @Override
    public char[] convert(int intHours) {

        checkArgument( intHours >= 0, "negative hours %s", intHours);

        int fiveHrCount = intHours / Constants.FIRST_HR_ROW_WEIGHT;
        int oneHrCount = intHours - (fiveHrCount*Constants.FIRST_HR_ROW_WEIGHT);

        char[] firstPart = convertHourPart(fiveHrCount);
        char[] secondPart = convertHourPart(oneHrCount);

        return new StringBuilder().append(firstPart).append(Constants.SPACE).append(secondPart).toString().toCharArray();
    }

    private char[] convertHourPart(int hrCount) {

        char[] hoursCharArray = new char[Constants.HR_SECTION_SIZE];

        Arrays.fill(hoursCharArray, 0, hrCount, Constants.RED);
        Arrays.fill(hoursCharArray, hrCount, Constants.HR_SECTION_SIZE, Constants.NULL);

        return hoursCharArray;
    }
}
