package com.scaler.core.utils;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * @created 09/09/22 7:52 am
 * @project Scaler_Beginners_Module
 * @author Deepak Kumar Rai
 */
public class TimeDateUtils {
    public static LocalTime startTime() {
        return LocalTime.now();
    }
    public static LocalTime endTime() {
        return LocalTime.now();
    }

    public static void endTime(LocalTime start) {
        diffTime(start, LocalTime.now());
    }
    public static void diffTime(LocalTime start, LocalTime end) {
        long hours = ChronoUnit.HOURS.between(start, end);
        long minutes = ChronoUnit.MINUTES.between(start, end);
        long seconds = ChronoUnit.SECONDS.between(start, end);
        long millis = ChronoUnit.MILLIS.between(start, end);
        System.out.println(hours +" hours : " + minutes +" minutes : " + seconds + " seconds : "
                + millis + " millis");
    }
    public static void executeTime(LocalTime start, LocalTime end) {
        long hours = ChronoUnit.HOURS.between(start, end);
        long minutes = ChronoUnit.MINUTES.between(start, end);
        long seconds = ChronoUnit.SECONDS.between(start, end);
        long millis = ChronoUnit.MILLIS.between(start, end);
        long micros = ChronoUnit.MICROS.between(start, end);
        long nano = ChronoUnit.NANOS.between(start, end);
        System.out.println("Execute Time: " + hours +" hours : " + minutes +" minutes : " + seconds + " seconds : "
                + millis + " millis " + micros + " micros " + nano + " nano");
    }
}
