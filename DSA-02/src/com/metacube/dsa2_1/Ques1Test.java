package com.metacube.dsa2_1;

import static org.junit.Assert.*;

import org.junit.Test;

public class Ques1Test {

//	Ques1 q = new Ques1();
	
	@Test
	public void test1() {
		String str = "4+2-3*5-4/4";
		String resStr = "-10";
		assertEquals(resStr,Ques1.evaluateValue(str));
	}
	
	@Test
	public void test2() {
		String str = "1+2-4==4-5";
		String resStr = "true";
		assertEquals(resStr,Ques1.evaluateValue(str));
	}
	
	@Test
	public void test3() {
		String str = "1+2-4==4-5&&4<=5";
		String resStr = "true";
		assertEquals(resStr,Ques1.evaluateValue(str));
	}
	
	@Test
	public void test4() {
		String str = "1+2-4==4-5&&4==5";
		String resStr = "false";
		assertEquals(resStr,Ques1.evaluateValue(str));
	}
	
	@Test
	public void test5() {
		String str = "1==1==1";
		String resStr = "error";
		assertEquals(resStr,Ques1.evaluateValue(str));
	}
	
	@Test
	public void test6() {
		String str = "1<=1||1>=1";
		String resStr = "true";
		assertEquals(resStr,Ques1.evaluateValue(str));
	}

}
