package com.metacube.Question02;


import static org.junit.Assert.*;
import org.junit.Test;

public class DetectLoopTest {

    @Test
    public void test_hasLoop_withLoop_shouldReturn_true() {
        LinkedList list = new LinkedList();
        LinkedList.insertData(list, 10);
        LinkedList.insertData(list, 20);
        LinkedList.insertData(list, 30);
        LinkedList.insertData(list, 40);
        LinkedList.insertData(list, 50);
        LinkedList.insertData(list, 60);
        LinkedList.insertData(list, 70);
        // LinkedList.insertData(list, 10);

        list.head.next.next.next.next = list.head;

        assertTrue(DetectLoop.hasLoop(list.head));
    }

    @Test
    public void test_hasLoop_withoutLoop_shouldReturn_false() {
        LinkedList list = new LinkedList();
        LinkedList.insertData(list, 10);
        LinkedList.insertData(list, 20);
        LinkedList.insertData(list, 30);
        LinkedList.insertData(list, 40);
        LinkedList.insertData(list, 50);
        LinkedList.insertData(list, 60);
        LinkedList.insertData(list, 70);
        // LinkedList.insertData(list, 10);

        assertFalse(DetectLoop.hasLoop(list.head));
    }

}
