package com.metacube.Question01;

import java.util.Scanner;

public class LinkedList {
    Node head;
    int size = 0;
    Node backward;
    Node forward;

    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public int getSize() {
        return size;
    }

    public LinkedList insertData(LinkedList list, int data) {

        Node newNode = new Node(data);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node node = list.head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
        size++;
        return list;
    }

    public static void printList(LinkedList list) {
        Node start = list.head;

        while (start != null) {
            System.out.print(start.data + " ");

            start = start.next;
        }
        System.out.println("\n");
    }

    // public LinkedList subLinklist(LinkedList list, int l, int r) {
    // if (l > r) {
    // System.out
    // .println("This case in not valid ( Left position can not be greater than right position ).");
    // return list;
    // }
    //
    // if (r == list.getSize() && l == 1) {
    // return list;
    // }
    //
    // LinkedList subList = new LinkedList();
    // boolean flag = false;
    // int counter = 1;
    //
    // while (list.head != null) {
    // if (flag) {
    // subList.insertData(subList, list.head.data);
    // }
    // if (counter == l - 1) {
    // backward = list.head;
    // System.out.println(backward.data + " backward");
    // }
    //
    // if (counter == l) {
    // subList.insertData(subList, list.head.data);
    // flag = true;
    // }
    //
    // if (counter == r) {
    // forward = list.head;
    // list.head = list.head.next;
    // System.out.println(forward.data + " forward");
    // break;
    // }
    // counter++;
    // list.head = list.head.next;
    // }
    //
    // return subList;
    // }

    public LinkedList rotate(LinkedList list, int left, int right, int number) {
        int count = 0;
        Node tempHead = head;
        Node LeftPointer = tempHead;
        Node RightPointer = null;
        Node LastPointer = null;
        Node RotationPointer = null;
        while (count != right) {
            count++;
            if (count == left - 1) {
                LeftPointer = tempHead;
            } else if (count == right) {
                RightPointer = tempHead;
                LastPointer = RightPointer.next;
            }
            tempHead = tempHead.next;
        }
        tempHead = head;
        count = 1;
        if (number > right - left) {
            number = number % (right - left + 1);
        }
        if (number == 0) {
            return list;
        }
        while (count != right - number) {
            tempHead = tempHead.next;
            count++;
        }
        RotationPointer = tempHead;
        if (left == 1 && right != 1) {
            head = RotationPointer.next;
            RightPointer.next = LeftPointer;
        } else {
            RightPointer.next = LeftPointer.next;
            LeftPointer.next = RotationPointer.next;
        }
        RotationPointer.next = LastPointer;
        return list;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        System.out.println("Please enter the Linklist : ");
        int x;
        do {
            x = 0;
            System.out.println("Please enter the data : ");
            int data = sc.nextInt();
            list.insertData(list, data);
            System.out.println("Do you want to add more elements :\nPress 1 : Yes\t\tOther : No");
            x = sc.nextInt();
        } while (x == 1);

        System.out.println("Enter value of L : ");
        int left = sc.nextInt();
        System.out.println("Enter value of R : ");
        int right = sc.nextInt();
        System.out.println("Enter value of N : ");
        int number = sc.nextInt();
        list.rotate(list, left, right, number);
        System.out.println("List after Rotation:");
        LinkedList.printList(list);
        sc.close();
    }

}
