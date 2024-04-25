package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {
    private EmployeeManager manager;

    @BeforeEach
    public void setUp() {
        manager = new EmployeeManager();
        manager.addEmployee();
    }

    @Test
    public void testAddEmployee() {
        assertEquals(1, manager.addEmployee());
        manager.addEmployee();
        assertEquals(2, manager.addEmployee());
    }

    @Test
    public void testAddExistingEmployee() {
        manager.addEmployee();
        assertEquals(1, manager.getEmployees().size());
        assertEquals("Иван Иванов", manager.findEmployeeById(1).getName()); // Имя не изменилось на "Иван Сидоров"
    }

    @Test
    public void testUpdateNonExistingEmployee() {
        manager.updateEmployee(999, "Новое Имя", "Новый отдел", 75000);
        assertNull(manager.findEmployeeById(999));
    }

    @Test
    public void testRemoveEmployee() {
        manager.removeEmployee(1);
        assertNull(manager.findEmployeeById(1));
    }
}
