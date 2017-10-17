package com.kunruh.chessclock.utils;

/**
 * Created by kyle on 10/16/17.
 */

public class Time {

    public static final String TIMER_FORMAT = "%02d:%02d:%02d.%d";

    private static final int MILLI_PER_HOUR = 1000 * 60 * 60;
    private static final int MILLI_PER_MIN = 1000 * 60;
    private static final int MILLI_PER_SEC = 1000;

    public static String milliToHMSM(long milliseconds) {

        long hours = milliseconds / MILLI_PER_HOUR;
        milliseconds -= hours * MILLI_PER_HOUR;

        long minutes = milliseconds / MILLI_PER_MIN;
        milliseconds -= minutes * MILLI_PER_MIN;

        long seconds = milliseconds / MILLI_PER_SEC;
        milliseconds -= seconds * MILLI_PER_SEC;

        return String.format(TIMER_FORMAT, hours, minutes, seconds, milliseconds/100);
    }
}
