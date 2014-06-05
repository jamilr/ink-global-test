package com.berlinconverter.entry;

import com.berlinconverter.core.HourConverter;
import com.berlinconverter.core.MinuteConverter;
import com.berlinconverter.core.SecondConverter;
import com.berlinconverter.core.SimpleBerlinConverter;
import com.berlinconverter.util.Constants;
import com.berlinconverter.util.IllegalTimeFormatException;

/**
 * @author Jamil Rzayev
 * @version June, 2014
 * SimpleBerlinConverterEntry is a class containing main method
 */


public class SimpleBerlinConverterEntry {

    private static SimpleBerlinConverter berlinConverter;

    public static void main(String... args) {

        if (args.length == 0)
            exit();

        String time = args[0];

        berlinConverter = new SimpleBerlinConverter();
        berlinConverter.setHourConverter( new HourConverter());
        berlinConverter.setMinuteConverter(new MinuteConverter());
        berlinConverter.setSecondConverter( new SecondConverter());

        tryConvert(time);
    }

    private static void tryConvert(String time) {

        String convertedTime;
        try {
            convertedTime = berlinConverter.convert(time);
            System.out.println(convertedTime);

        } catch (IllegalTimeFormatException pEx) {
            exit();
        }
    }

    private static void exit() {
        System.out.println(Constants.ERROR_MESSAGE);
        System.exit(-1);
    }
}
