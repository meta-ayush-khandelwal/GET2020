import org.junit.Test;
import static org.junit.Assert.*;

public class TestStringOperation {
	StringOperation ope=new StringOperation();
	@Test
	public void testStringCompare(){
		int ans=ope.stringCompare("Ayush", "ayush");
		assertEquals(0, ans);
	}
	
	@Test
	public void negativeTestStringCompare(){
		int ans=ope.stringCompare("He is a boy", "He is A boy");
		assertNotEquals(1, ans);
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionInCompare(){
		ope.stringCompare("Ayush", "");
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionInReverse(){
		ope.stringReverse("");
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionInLargestWord(){
		ope.largestWord("");
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionInCaseConvertor(){
		ope.stringCaseConvertor("");
	}
	
	@Test
	public void testLargestWord() {
		String ans=ope.largestWord("My name is khan");
		assertEquals("khan", ans);
	}
	
	@Test
	public void negativeTestLargestWord() {
		String ans=ope.largestWord("My name is khan");
		assertNotEquals("Khan", ans);
	}
	
	@Test
	public void testCaseConvertor() {
		String ans=ope.stringCaseConvertor("My name is khaN");
		assertEquals("mY NAME IS KHAn", ans);
	}
	
	@Test
	public void NegativeTestCaseConvertor() {
		String ans=ope.stringCaseConvertor("My name is khaN");
		assertNotEquals("mY NAME is KHAn", ans);
	}
	
	@Test
	public void testStringReverse() {
		String ans=ope.stringReverse("Ayush");
		assertEquals("hsuyA", ans);
	}

	@Test
	public void NegativeTestStringReverse() {
		String ans=ope.stringReverse("Ayush");
		assertNotEquals("Ayush", ans);
	}

}
