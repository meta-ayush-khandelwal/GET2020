import java.util.Scanner;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestHexCalc {
	HexCalc obj=new HexCalc();

	@Test
	public void testAddNumbers(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		String ans= obj.addNumbers();
		assertEquals("35", ans);
	}

	@Test
	public void testSubNumbers(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		String ans= obj.subNumbers();
		assertEquals("1", ans);
	}

	@Test
	public void testMulNumbers(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		String ans= obj.multiplyNumbers();
		assertEquals("2BE", ans);
	}

	@Test
	public void testDivideNumbers(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		String ans= obj.divideNumbers();
		assertEquals("0 Remainder is:1A", ans);
	}
	
	@Test
	public void negativeTestAddNumbers(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		String ans= obj.addNumbers();
		assertNotEquals("36", ans);
	}

	@Test
	public void negativeTestSubNumbers(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		String ans= obj.subNumbers();
		assertNotEquals("A", ans);
	}

	@Test
	public void negativeTestMulNumbers(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		String ans= obj.multiplyNumbers();
		assertNotEquals("2BF", ans);
	}

	@Test
	public void negativeTestDivideNumbers(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		String ans= obj.divideNumbers();
		assertNotEquals("0 Remainder is:1B", ans);
	}
	
	@Test
	public void testDecimalToHex(){
		obj.base=16;
		String ans= obj.decimalToHex(6543);
		assertEquals("198F", ans);
	}
	
	@Test
	public void testHexToDecimal(){
		obj.base=16;
		long ans= obj.hexToDecimal("AAB8");
		assertEquals(43704, ans);
	}
	
	@Test
	public void negativeTestDecimalToHex(){
		obj.base=16;
		String ans= obj.decimalToHex(6543);
		assertNotEquals("198E", ans);
	}
	
	@Test
	public void negativeTestHexToDecimal(){
		obj.base=16;
		long ans= obj.hexToDecimal("AAB8");
		assertNotEquals(43708, ans);
	}
	
	@Test
	public void testEqualNumbers(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		boolean ans= obj.equalNumbers();
		assertEquals(false, ans);
	}
	
	@Test
	public void testGreaterNumber(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		boolean ans= obj.greaterNumber();
		assertEquals(false, ans);
	}
	
	@Test
	public void testLesserNumber(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		boolean ans= obj.lesserNumber();
		assertEquals(true, ans);
	}

	@Test
	public void negativeTestEqualNumbers(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		boolean ans= obj.equalNumbers();
		assertNotEquals(true, ans);
	}
	
	@Test
	public void negativeTestGreaterNumber(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		boolean ans= obj.greaterNumber();
		assertNotEquals(true, ans);
	}
	
	@Test
	public void negativeTestLesserNumber(){
		obj.firstNumber="1a";
		obj.secondNumber="1b";
		obj.base=16;
		boolean ans= obj.lesserNumber();
		assertNotEquals(false, ans);
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionInAddNumbers(){
		obj.addNumbers();
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionInSubNumbers(){
		obj.subNumbers();
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionInMulNumbers(){
		obj.multiplyNumbers();
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionInDivideNumber(){
		obj.divideNumbers();
	}
	
	@Test (expected=NumberFormatException.class)
	public void testExceptionInDecimalToHex(){
		obj.decimalToHex(Long.parseLong(""));
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionInHexToDecimal(){
		obj.hexToDecimal("");
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionInEqualNumber(){
		obj.equalNumbers();
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionInGreaterNumber(){
		obj.greaterNumber();
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionInLesserNumber(){
		obj.lesserNumber();
	}
}
