import static org.junit.Assert.*;

import org.junit.Test;

public class TestMarksheet {

	@Test
	public void testAverage(){
		float ans=Marksheet.gradeAverage(new float[]{45.0f,23.0f,80.0f,55.0f,77.0f});
		assertEquals(56.00f, ans, 0.009);
	}
	
	@Test
	public void testMinMax(){
		float ans[]=Marksheet.minMaxGrade(new float[]{45.0f,23.0f,80.0f,55.0f,77.0f});
		assertEquals(23.00f, ans[0], 0.009);
		assertEquals(80.00f, ans[1], 0.009);
	}
	
	@Test
	public void testPassPercentage(){
		float ans=Marksheet.passStudentsPercentage(new float[]{45.0f,23.0f,80.0f,55.0f,77.0f});
		assertEquals(80.00f, ans, 0.009);
	}
	
	@Test
	public void negativeTestAverage(){
		float ans=Marksheet.gradeAverage(new float[]{45.0f,23.0f,80.0f,55.0f,77.0f});
		assertNotEquals(55.00f, ans, 0.009);
	}
	
	@Test
	public void negativeTestMinMax(){
		float ans[]=Marksheet.minMaxGrade(new float[]{45.0f,23.0f,80.0f,55.0f,77.0f});
		assertNotEquals(45.00f, ans[0], 0.009);
		assertNotEquals(77.00f, ans[1], 0.009);
	}
	
	@Test
	public void negativeTestPassPercentage(){
		float ans=Marksheet.passStudentsPercentage(new float[]{45.0f,23.0f,80.0f,55.0f,77.0f});
		assertNotEquals(70.00f, ans, 0.009);
	}
	
	@Test(expected=ArithmeticException.class)
	public void testAverageException(){
		Marksheet.gradeAverage(new float[]{});
	}
	
	@Test(expected=ArithmeticException.class)
	public void testMinMaxException(){
		Marksheet.minMaxGrade(new float[]{});
	}
	
	@Test(expected=ArithmeticException.class)
	public void testPassPercentageException(){
		Marksheet.passStudentsPercentage(new float[]{});
	}
}
