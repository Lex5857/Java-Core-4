package javaCore.Lesson4.src.employee_registry;

import java.util.ArrayList;
import java.util.List;

import javaCore.Lesson4.src.employee.Employee;;

public class EmployeeRegistry {
    private List<Employee> employees;

    public EmployeeRegistry() {
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees(){
        return this.employees;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }
}
