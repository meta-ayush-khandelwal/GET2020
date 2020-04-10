package com.metacube.Question02;

public class Employee {
    private int empId;
    private String name;
    private int salary;
    private int age;

    public Employee(int empId, String name, int salary, int age) {
        try {
            if (name == null) {
                throw new Exception("name can't be null");
            }
            this.empId = empId;
            this.name = name;
            this.salary = salary;
            this.age = age;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        try {
            if (name == null) {
                throw new Exception("name cant be null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return name;
    }

    public void setName(String name) {
        try {
            if (name == null) {
                throw new Exception("data cant be null");
            }

            this.name = name;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee Id: " + empId);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);
        System.out.println("Employee Age: " + age);
    }

}
