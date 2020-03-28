package Question1;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

public class TestEmployeeOperations {
    @Test
    public void test_addEmployee_withValidEmployeeObjects_shouldReturn_true() {
        EmployeeOperations employeeMain = new EmployeeOperations();
        try {
            assertTrue(employeeMain.addEmployee(new Employee(1, "Ayush", "Surat")));
            assertTrue(employeeMain.addEmployee(new Employee(2, "Deepak", "Jaipur")));
            assertTrue(employeeMain.addEmployee(new Employee(3, "Rajat", "Bhiwadi")));
            assertTrue(employeeMain.addEmployee(new Employee(4, "Sharad", "Jaipur")));
            assertTrue(employeeMain.addEmployee(new Employee(5, "Rahul", "Allahbaad")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSortByID_withValidEmployeeObjects_shouldReturn_true() {
        EmployeeOperations employeeMain = new EmployeeOperations();
        try {
            assertTrue(employeeMain.addEmployee(new Employee(1, "Ayush", "Surat")));
            assertTrue(employeeMain.addEmployee(new Employee(5, "Deepak", "Jaipur")));
            assertTrue(employeeMain.addEmployee(new Employee(2, "Rajat", "Bhiwadi")));
            assertTrue(employeeMain.addEmployee(new Employee(3, "Sharad", "Jaipur")));
            assertTrue(employeeMain.addEmployee(new Employee(9, "Rahul", "Allahbaad")));
            List<Employee>employees=employeeMain.getListOfEmployee();
            List<Employee> sortEmployees = Sort.sortEmployeesById(employees);
            for (Employee e : sortEmployees) {
                System.out.println(e.getEmpid() + " " + e.getName() + " " + e.getAddress());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSortByName_withValidEmployeeObjects_shouldReturn_true() {
        EmployeeOperations employeeMain = new EmployeeOperations();
        try {
            assertTrue(employeeMain.addEmployee(new Employee(1, "Ayush", "Surat")));
            assertTrue(employeeMain.addEmployee(new Employee(5, "Deepak", "Jaipur")));
            assertTrue(employeeMain.addEmployee(new Employee(2, "Rajat", "Bhiwadi")));
            assertTrue(employeeMain.addEmployee(new Employee(3, "Sharad", "Jaipur")));
            assertTrue(employeeMain.addEmployee(new Employee(9, "Rahul", "Allahbaad")));
            List<Employee>employees=employeeMain.getListOfEmployee();
            List<Employee> sortEmployees = Sort.sortEmployeesByName(employees);
            for (Employee e : sortEmployees) {
                System.out.println(e.getEmpid() + " " + e.getName() + "-- " + e.getAddress());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
