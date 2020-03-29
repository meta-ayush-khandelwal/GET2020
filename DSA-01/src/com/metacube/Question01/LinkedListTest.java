package com.metacube.Question01;

import org.junit.Test;

public class LinkedListTest {

    @Test
    public void testRotation(){
        LinkedList list = new LinkedList();
        list.insertData(list, 10);
        list.insertData(list, 20);
        list.insertData(list, 30);
        list.insertData(list, 40);
        list.insertData(list, 50);
        list.insertData(list, 60);
        list.insertData(list, 70);
        LinkedList rotatedList= list.rotate(list, 2, 6, 2);
        LinkedList.printList(rotatedList);
    }
}
