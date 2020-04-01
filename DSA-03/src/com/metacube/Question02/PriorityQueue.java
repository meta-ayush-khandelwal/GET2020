package com.metacube.Question02;

import java.util.ArrayList;

public class PriorityQueue {
    Node[] node;
    int start = 0;
    int end = 0;

    public PriorityQueue(int size) {
        node = new Node[size];
    }

    private ArrayList<Integer> getPriorityList() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = start; i < end; i++) {
            list.add(node[i].getPriority());
        }
        return list;
    }

    public void enqueue(Node node) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        } else {
            ArrayList<Integer> list = getPriorityList();
            if (list.contains(node.getPriority())) {
                System.out.println("Priority Exists");
                return;
            }
            this.node[end++] = node;
            System.out.println("Inserted");
            getSorted();
            // showQueue();

        }
    }

    public boolean isFull() {
        if (end > node.length - 1) {
            return true;
        }
        return false;
    }

    private void getSorted() {
        for (int i = start; i <= end; i++) {
            for (int j = start; j < end - i - 1; j++) {
                if (node[j].getPriority() > node[j + 1].getPriority()) {
                    Node temp = node[j];
                    node[j] = node[j + 1];
                    node[j + 1] = temp;
                }
            }
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            // throw new Exception("Queue is Empty");
            System.out.println("Queue is Empty");
            return;
        } else {
            getSorted();
            Node deletedNode = node[start++];
            System.out.println("Deleted: data-" + deletedNode.getData() + "\tPriority"
                    + deletedNode.getPriority());

        }
    }

    public void showQueue(PriorityQueue queue) {
        for (int i = start; i < end; i++) {
            System.out.println(queue.node[i].getData() + "\t" + queue.node[i].getPriority() + "\n");
        }
    }

    public boolean isEmpty() {
        if (start == end)
            return true;
        return false;
    }
}
