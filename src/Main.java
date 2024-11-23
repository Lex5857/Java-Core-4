package javaCore.Lesson4.src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javaCore.Lesson4.src.holidays.Holidays;
import javaCore.Lesson4.src.employee_registry.EmployeeRegistry;
import javaCore.Lesson4.src.builder.EmployeeBuilder;
import javaCore.Lesson4.src.builder.HolidayBuilder;
import javaCore.Lesson4.src.employee.Employee;
import javaCore.Lesson4.src.employee.Gender;
import javaCore.Lesson4.src.holiday.Holiday;

public class Main {
    public static void main(String[] args) {
        HolidayBuilder holidayBuilder = HolidayBuilder.getHolidayBuilder();
        Holiday holiday1 = holidayBuilder.builder("8 марта", 8, 3);
        Holiday holiday2 = holidayBuilder.builder("23 февраля", 23, 2);
        Holiday holiday3 = holidayBuilder.builder("Новый Год", 1, 1);

        Holidays holidays = new Holidays();
        holidays.addHoliday(holiday1);
        holidays.addHoliday(holiday2);
        holidays.addHoliday(holiday3);

        EmployeeBuilder employeeBuilder = EmployeeBuilder.getEmployeeBuilder();
        Employee employee1 = employeeBuilder.builder("Вася", Gender.MALE, addDateOfBirth("10.02.1982"));
        Employee employee2 = employeeBuilder.builder("Анастасия", Gender.FEMALE, addDateOfBirth("16.05.1990"));

        EmployeeRegistry employeeRegistry = new EmployeeRegistry();
        employeeRegistry.addEmployee(employee1);
        employeeRegistry.addEmployee(employee2);

        Holiday holidayToday = whatHolidayToday(holidays);
        congratulation(employeeRegistry, holidayToday);
    }

    private static Holiday whatHolidayToday(Holidays holidays){
        for (Holiday holiday : holidays.getHolidays()) {
            if(isHolidayDay(holiday)){
                return holiday;
            }
        }
        return null;
    }

    private static Boolean isHolidayDay(Holiday holiday){
        LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();
        int currentMonth = currentDate.getMonthValue();
        int day = holiday.getDay();
        int month = holiday.getMonth();
        if (currentDay == day && currentMonth == month){
            return true;
        }
        return false; 
    }

    private static void congratulation(EmployeeRegistry employees, Holiday holiday) {
        for (Employee employee : employees.getEmployees()) {
            if (holiday == null){
                System.out.println(String.format("%s нет праздника", employee.getName()));
            } else if (employee.getGender() == Gender.MALE && holiday.getDay() == 23 && holiday.getMonth() == 2) {
                System.out.println(String.format("%s c %s", employee.getName(), holiday.getName()));
            } else if (employee.getGender() == Gender.FEMALE && holiday.getDay() == 8 && holiday.getMonth() == 3) {
                System.out.println(String.format("%s c %s", employee.getName(), holiday.getName()));
            } else if (holiday.getDay() == 1 && holiday.getMonth() == 1) {
                System.out.println(String.format("%s c Новым Годом", employee.getName()));
            }
        }
    }

    private static LocalDate addDateOfBirth(String dateOfBirthStr){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return LocalDate.parse(dateOfBirthStr, formatter);
        } catch (DateTimeParseException e){
            return null;
        }
    }
}
