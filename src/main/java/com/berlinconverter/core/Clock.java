package com.berlinconverter.core;

/**
 * @author Jamil Rzayev
 * @version June, 2014
 *
 * Clock is a data structure that represents hours, minutes, and seconds
 *
 */
public class Clock {

    private int hours;

    private int minutes;

    private int seconds;

    public Clock(){
        this.hours = 0;
        this.minutes = 0;
        this.seconds = 0;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }
}
