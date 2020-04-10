package com.metacube.Question02;

public class Node {
    public Employee data;
    public Node next;

    public Node(Employee data) {
        try {
            if (data == null) {
                throw new Exception("employee data can't be null");
            }
            this.data = data;
            this.next = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee getData() {
        try {
            if (data == null) {
                throw new Exception("data cant be null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(Employee data) {
        try {
            if (data == null) {
                throw new Exception("data cant be null");
            }

            this.data = data;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
