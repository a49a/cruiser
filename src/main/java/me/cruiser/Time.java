package me.cruiser;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import java.util.Calendar;

public class Time {
    public static void main(String[] args) {
        DateTime dateTime = DateTime.now();
        long servingStartTime = Calendar.getInstance().getTimeInMillis();
        DateTime last = dateTime.plusMinutes(30);
        Interval interval = new Interval(dateTime, last);
        System.out.println(interval.toDuration().toStandardMinutes());
        System.out.println(dateTime.getMillis());
        System.out.println(servingStartTime);

        String a;
        System.out.println(a = "a");

        System.out.println(Long.compare(3, 1));
    }
}
