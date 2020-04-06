package com.metacube.dsa2_2;

import java.util.Scanner;

public class Ques2 {
	
	static queueImpl que = new queueImpl();
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Please enter the queue : ");
		int x=0;
		do {
			System.out.println("Please enter the element : ");
			int ele = sc.nextInt();
			que.enqueue(ele);
			System.out.println("Want to enter more elements : Press\n1 : Yes\t\tOther : No");
			x = sc.nextInt();
		} while(x==1);
		
		while(x!=1) {
			System.out.println("\nSelect which operation you want to perform :");
			System.out.println("1. Insert element");
			System.out.println("2. Delete element");
			System.out.println("3. Check whether queue is full or not");
			System.out.println("4. Check whether queue is empty or not");
			System.out.println("5. Exit");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter the element : ");
				int val = sc.nextInt();
				que.enqueue(val);
				break;
			case 2:
				val = que.dequeue();
				System.out.println("Element " + val + " has been deleted");
				break;
			case 3:
				Boolean value = que.isFull();
				if( value ) {
					System.out.println("Queue is Full");
				} else {
					System.out.println("Queue is not Full");
				}
				break;
			case 4:
				value = que.isEmpty();
				if( value ) {
					System.out.println("Queue is Empty");
				} else {
					System.out.println("Queue is not Empty");
				}
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Enter a valid choice");
				break;
			}
		}
		sc.close();
	}
	
	public static String insertQueue() {
		que.enqueue(10);
		que.enqueue(20);
		que.enqueue(30);
		que.enqueue(40);
		que.enqueue(50);
		return "inserted";
	}
	
	public static String insertElement(int element) {
		return que.enqueue(element);
	}
	
	public static boolean checkEmpty() {
		if( que.isEmpty() ) {
			return true;
		}
		return false;
	}
	
	public static boolean checkFull() {
		if( que.isFull() ) {
			return true;
		}
		return false;
	}
	
	public static int deleteFromQueue() {
		return que.dequeue();
	}
}
