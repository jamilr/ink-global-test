package com.berlinconverter.util;

/**
 *
 * @author Jamil Rzayev
 * @version June, 2014
 * Class com.berlinconverter.util.IllegalTimeFormatException extends from Exception class representing the type of Exception when provided time is of a wrong format
 * A correct time format for Berlin Clock Converter is  [HH:mm:ss]
 */
public class IllegalTimeFormatException extends Exception {

    public IllegalTimeFormatException(String msg) {
        super(msg);
    }
}
