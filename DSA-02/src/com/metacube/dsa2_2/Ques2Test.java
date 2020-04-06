package com.metacube.dsa2_2;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ques2Test {

	@Test
	public void testEnqueue1() {
		assertEquals("inserted",Ques2.insertQueue());
	}
	
	@Test
	public void testEnqueue2() {
		assertEquals("Full",Ques2.insertElement(10));
	}
	
	@Test
	public void testEmpty1() {
		assertFalse(Ques2.checkEmpty());
	}
	
	@Test
	public void testFull1() {
		assertTrue(Ques2.checkFull());
	}

}
