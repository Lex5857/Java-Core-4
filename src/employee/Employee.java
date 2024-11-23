package javaCore.Lesson4.src.employee;

import java.time.LocalDate;

public class Employee {
    private String name;
    private Gender gender;
    private LocalDate dateOfBirth;

    public Employee(String name, Gender gender, LocalDate dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
