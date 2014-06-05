package com.berlinconverter.core;

/**
 * @author Jamil Rzayev
 * @version June, 2014
 * ClockPartConverter is an interface for implementing specific time part converters (Minute, Hour, Second) into Berlin Clock Format
 */

public interface ClockPartConverter {

    char[] convert(int value);
}
