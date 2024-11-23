package javaCore.Lesson4.src.builder;

import java.time.LocalDate;

import javaCore.Lesson4.src.employee.Employee;
import javaCore.Lesson4.src.employee.Gender;

public class EmployeeBuilder {
    private static EmployeeBuilder employeeBuilder;

    public static EmployeeBuilder getEmployeeBuilder(){
        if (employeeBuilder == null){
            employeeBuilder = new EmployeeBuilder();
        }
        return employeeBuilder;
    }

    public Employee builder(String name, Gender gender, LocalDate dateOfBirth){
        return new Employee(name, gender, dateOfBirth);
    }
}
