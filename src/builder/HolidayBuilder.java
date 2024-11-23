package javaCore.Lesson4.src.builder;

import javaCore.Lesson4.src.holiday.Holiday;

public class HolidayBuilder {
    private static HolidayBuilder holidayBuilder;

    public static HolidayBuilder getHolidayBuilder(){
        if (holidayBuilder == null){
            holidayBuilder = new HolidayBuilder();
        }
        return holidayBuilder;
    }

    public Holiday builder(String name, int day, int month){
        return new Holiday(name, day, month);
    }
}
