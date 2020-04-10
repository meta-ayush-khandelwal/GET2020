package com.metacube.Question02;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestLinkedListEmployee {

    @Test
    public void test() {
        int[] expected = new int[] {800, 600, 500};
        int[] result = new int[3];

        LinkedListEmployee list = new LinkedListEmployee();
        Employee e = new Employee(1, "Ankur", 500, 19);
        list = list.insert(list, e);
        Employee e1 = new Employee(2, "Ayush", 600, 18);
        list = list.insert(list, e1);
        Employee e2 = new Employee(3, "Ankit", 800, 17);
        list = list.insert(list, e2);
        list = list.insertionSort(list);
        Node n = new Node(e);
        n = list.head;
        int i = 0;
        while (n.next != null) {
            result[i] = n.getData().getSalary();
            i++;
            n = n.next;

        }
        result[i] = n.getData().getSalary();
        assertArrayEquals(expected, result);
    }

    @Test
    public void test1() {
        int[] expected = new int[] {800, 500, 500};
        int[] result = new int[3];

        LinkedListEmployee list = new LinkedListEmployee();
        Employee e = new Employee(1, "krishana", 500, 19);
        list = list.insert(list, e);
        Employee e1 = new Employee(2, "krishan", 500, 18);
        list = list.insert(list, e1);
        Employee e2 = new Employee(3, "kanha", 800, 17);
        list = list.insert(list, e2);
        list = list.insertionSort(list);
        Node n = new Node(e);
        n = list.head;
        int i = 0;
        while (n.next != null) {
            result[i] = n.getData().getSalary();
            i++;
            n = n.next;

        }
        result[i] = n.getData().getSalary();
        assertArrayEquals(expected, result);
    }

    @Test
    public void test3() {
        int[] expected = new int[] {800, 800, 800};
        int[] result = new int[3];

        LinkedListEmployee list = new LinkedListEmployee();
        Employee e = new Employee(1, "krish", 800, 19);
        list = list.insert(list, e);
        Employee e1 = new Employee(2, "kapoor", 800, 18);
        list = list.insert(list, e1);
        Employee e2 = new Employee(3, "Gupta", 800, 17);
        list = list.insert(list, e2);
        list = list.insertionSort(list);
        Node n = new Node(e);
        n = list.head;
        int i = 0;
        while (n.next != null) {
            result[i] = n.getData().getSalary();
            i++;
            n = n.next;

        }
        result[i] = n.getData().getSalary();
        assertArrayEquals(expected, result);
    }

}
