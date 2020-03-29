package com.metacube.Question03;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiVarPolyTest {

	MultiVarPoly object  = new MultiVarPoly();
	
	@Test
	public void positiveTestCase(){
		int array1[] =new int[]{0,2,3};
		int array2[] =new int[]{0,2,3};
		int array3[] =new int[]{0,3,7};
		object.createLinkList(3,array1);
		object.createLinkList(3,array2);
		object.createLinkList(3,array3);
		assertEquals( 10,object.findDegree() );
	}
	
	@Test
	public void positiveTestCase1(){
		int array1[] =new int[]{0,0,0};
		object.createLinkList(0,array1);
	
		assertEquals(0,object.findDegree() );
	}
	
	@Test(expected=ArithmeticException.class)
	public void negativeTestCase(){
		int array1[] =new int[]{0,2,3};
		int array2[] =new int[]{0,1/0,3};
		object.createLinkList(3,array1);
		object.createLinkList(3,array2);
		assertEquals( 10,object.findDegree() );
	}
	
	
}
