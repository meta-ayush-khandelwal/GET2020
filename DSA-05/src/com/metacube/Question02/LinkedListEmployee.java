package com.metacube.Question02;

public class LinkedListEmployee {
    public Node head;
    Node sorted;
    int data;

    public LinkedListEmployee() {
        head = null;

    }

    public LinkedListEmployee insert(LinkedListEmployee list, Employee data) {
        try {
            if (list == null) {
                throw (new Exception("list cant be null"));
            }
            if (data == null) {
                throw (new Exception("employee cant be null"));
            }
            Node newNode = new Node(data);
            if (list.head == null) {
                list.head = newNode;
            } else {
                Node last = head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = newNode;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return list;
    }

    public LinkedListEmployee insertionSort(LinkedListEmployee list) {
        try {
            if (list == null) {
                throw new Exception("list cant be null");
            }

            sorted = null;
            Node current = list.head;
            while (current != null) {
                Node next = current.next;
                sortedInsert(current);
                current = next;
            }
            head = sorted;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void sortedInsert(Node newNode) {
        try {
            if (newNode == null) {
                throw new Exception("newNode can't be null");
            }
            Node current = sorted;
            if (sorted == null || sorted.getData().getSalary() < newNode.getData().getSalary()) {
                newNode.next = sorted;
                sorted = newNode;
            } else if (current.getData().getSalary() == newNode.getData().getSalary()) {
                if (current.getData().getAge() < newNode.getData().getAge()) {

                    newNode.next = current.next;
                    current.next = newNode;
                } else {
                    newNode.next = sorted;
                    sorted = newNode;
                }

            } else {

                while (current.next != null
                        && current.getData().getSalary() > newNode.getData().getSalary()) {

                    current = current.next;
                }

                newNode.next = current.next;
                current.next = newNode;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void display(LinkedListEmployee list) {
        try {
            if (list == null) {
                throw new Exception("can't display a null list");
            }
            Node current = list.head;

            if (list.head == null) {
                System.out.println("List is empty");
                return;
            }
            System.out.println("Nodes of singly linked list: ");
            while (current.next != null) {
                current.getData().displayEmployeeInfo();
                current = current.next;
            }
            current.getData().displayEmployeeInfo();
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
