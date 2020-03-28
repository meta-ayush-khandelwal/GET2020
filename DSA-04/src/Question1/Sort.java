package Question1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

    public static List<Employee> sortEmployeesByName(List<Employee> employees) {
        Collections.sort(employees, new SortByName());
        return employees;
    }

    public static List<Employee> sortEmployeesById(List<Employee> employees) {
        Collections.sort(employees, new SortById());
        return employees;
    }
}


class SortByName implements Comparator<Employee> {
    public int compare(Employee employee1, Employee employee2) {
        String empName1 = employee1.getName().toUpperCase();
        String empName2 = employee2.getName().toUpperCase();
        return empName1.compareTo(empName2);
    }
}


class SortById implements Comparator<Employee> {
    public int compare(Employee employee1, Employee employee2) {
        return employee1.getEmpid() - employee2.getEmpid();
    }
}
