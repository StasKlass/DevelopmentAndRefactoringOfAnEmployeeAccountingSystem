package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {

    @Test
    void testAddAndFindEmployee() {
        EmployeeManager manager = new EmployeeManager();
        Employee emp = new Employee(1, "John Doe", "HR", 50000);
        manager.addEmployee(emp);
        assertNotNull(manager.findEmployeeById(1));
        assertEquals("John Doe", manager.findEmployeeById(1).getName());
    }

    @Test
    void testUpdateEmployee() {
        EmployeeManager manager = new EmployeeManager();
        Employee emp = new Employee(2, "Jane Doe", "Marketing", 60000);
        manager.addEmployee(emp);
        manager.updateEmployee(2, "Jane Smith", "Sales", 65000);
        assertEquals("Jane Smith", manager.findEmployeeById(2).getName());
        assertEquals("Sales", manager.findEmployeeById(2).getDepartment());
        assertEquals(65000, manager.findEmployeeById(2).getSalary());
    }

    @Test
    void testRemoveEmployee() {
        EmployeeManager manager = new EmployeeManager();
        Employee emp = new Employee(3, "Jim Beam", "Production", 40000);
        manager.addEmployee(emp);
        manager.removeEmployee(3);
        assertNull(manager.findEmployeeById(3));
    }
    @Test
    void testAddEmployee() {
        EmployeeManager manager = new EmployeeManager();
        Employee emp = new Employee(1, "John Doe", "HR", 50000);
        manager.addEmployee(emp);
        assertEquals(emp, manager.findEmployeeById(1));
    }
}