package javaCore.Lesson4.src.holidays;

import java.util.ArrayList;
import java.util.List;

import javaCore.Lesson4.src.holiday.Holiday;

public class Holidays {
    private List<Holiday> holidays;

    public Holidays() {
        holidays = new ArrayList<>();
    }

    public List<Holiday> getHolidays(){
        return this.holidays;
    }

    public void addHoliday(Holiday holiday){
        holidays.add(holiday);
    }
}
