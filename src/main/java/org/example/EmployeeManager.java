package org.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId() == employee.getEmployeeId()) {
                System.out.println("Employee with ID " + employee.getEmployeeId() + " already exists.");
                return;
            }
        }
        employees.add(employee);
        System.out.println("Employee added: " + employee.getEmployeeId());
    }

    public void updateEmployee(int employeeId, String name, String department, double salary) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId() == employeeId) {
                emp.setName(name);
                emp.setDepartment(department);
                emp.setSalary(salary);
                System.out.println("Employee updated: " + employeeId);
                return;
            }
        }
        System.out.println("Employee not found with ID: " + employeeId);
    }
    public void removeEmployee(int employeeId) {
        employees.removeIf(emp -> emp.getEmployeeId() == employeeId);
        System.out.println("Employee removed: " + employeeId);
    }

    public Employee findEmployeeById(int employeeId) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId() == employeeId) {
                return emp;
            }
        }
        System.out.println("Employee not found with ID: " + employeeId);
        return null;
    }

    public void displayAllEmployees() {
        for (Employee emp : employees) {
            emp.displayInfo();
        }
    }
    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }
}