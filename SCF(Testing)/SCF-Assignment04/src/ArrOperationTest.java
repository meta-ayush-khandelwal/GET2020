import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.experimental.runners.Enclosed;
import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class ArrOperationTest {
	@RunWith(Parameterized.class)
	public static class ParamTestsForSplitArray {
		private int[] numbers;
		private int expectedOutput;

		@Parameterized.Parameters
		public static Collection input() {
			return Arrays.asList(new Object[][]{
					{new int[]{1, 1, 1, 2, 1}, 3},
					{new int[]{2, 1, 1, 2, 1}, -1},
					{new int[]{10, 10}, 1},
					{new int[]{3, 7, 2, 12},3}
			});
		}

		public ParamTestsForSplitArray(int[] numbers,int expectedOutput){
			this.numbers = numbers;
			this.expectedOutput = expectedOutput;
		}

		@Test
		public void testSplitArray() {
			int actualOutput = ArrOperation.splitArray(numbers);
			assertEquals(expectedOutput, actualOutput);
		}
	}

	@RunWith(Parameterized.class)
	public static class ParamTestsForMaxMirror {
		private int[] numbers;
		private int expectedOutput;

		@Parameterized.Parameters
		public static Collection input() {
			return Arrays.asList(new Object[][]{
					{new int[]{1, 1, 1, 2, 1}, 3},
					{new int[]{1,2,3,1,2,3,2,1}, 5},
					{new int[]{10, 10}, 2},
					{new int[]{1},1}
			});
		}

		public ParamTestsForMaxMirror(int[] numbers,int expectedOutput){
			this.numbers = numbers;
			this.expectedOutput = expectedOutput;
		}

		@Test
		public void testMaxMirror() {
			int actualOutput = ArrOperation.maxMirror(numbers);
			assertEquals(expectedOutput, actualOutput);
		}
	}

	@RunWith(Parameterized.class)
	public static class ParamTestsForCountClumps {
		private int[] numbers;
		private int expectedOutput;

		@Parameterized.Parameters
		public static Collection input() {
			return Arrays.asList(new Object[][]{
					{new int[]{1,2,2,3,4,4}, 2},
					{new int[]{1,1,2,3,3,3,1,1,2,2,3}, 4},
					{new int[]{10, 10}, 1},
					{new int[]{1},0}
			});
		}

		public ParamTestsForCountClumps(int[] numbers,int expectedOutput){
			this.numbers = numbers;
			this.expectedOutput = expectedOutput;
		}

		@Test
		public void testCountClumps() {
			int actualOutput = ArrOperation.countClumps(numbers);
			assertEquals(expectedOutput, actualOutput);
		}
	}

	@RunWith(Parameterized.class)
	public static class ParamTestsForFixXY {
		private int[] numbers;
		private int expectedOutput[];
		private int X=4;
		private int Y=5;

		@Parameterized.Parameters
		public static Collection input() {
			return Arrays.asList(new Object[][]{
					{new int[]{5, 4, 9, 4, 9, 5},new int[] {9, 4, 5, 4, 5, 9}},
					{new int[]{1, 4, 1, 5}, new int[]{1,4,5,1}},
					{new int[]{1, 4, 1, 5, 5, 4, 1}, new int[]{1, 4, 5, 1, 1, 4, 5}},
					{new int[]{1,2,3,4,5,6,7},new int[]{1,2,3,4,5,6,7}}
			});
		}

		public ParamTestsForFixXY(int[] numbers,int[] expectedOutput){
			this.numbers = numbers;
			this.expectedOutput = expectedOutput;
		}

		@Test
		public void testMaxMirror() {
			int[] actualOutput = ArrOperation.fixXY(numbers,X,Y);
			assertArrayEquals(expectedOutput, actualOutput);
		}
	}

	public static class testException{
		@Test (expected=AssertionError.class)
		public void testfixXYAssertionErrorOnEmpty(){
			ArrOperation.fixXY(new int[]{}, 4, 5);
		}

		@Test (expected=AssertionError.class)
		public void testClumpsAssertionErrorOnEmpty(){
			ArrOperation.countClumps(new int[]{});
		}

		@Test (expected=AssertionError.class)
		public void testSplitAssertionErrorOnEmpty(){
			ArrOperation.splitArray(new int[]{});
		}
		

		@Test (expected=AssertionError.class)
		public void testMirrorAssertionErrorOnEmpty(){
			ArrOperation.maxMirror(new int[]{});
		}
		
		@Test (expected=AssertionError.class)
		public void testAssertionErrorOnXAtLast(){
			ArrOperation.fixXY(new int[]{1,2,3,5,4,5,4}, 4, 5);
		}

		@Test (expected=AssertionError.class)
		public void testAssertionErrorOnUnequalXY(){
			ArrOperation.fixXY(new int[]{1,2,3,4,5,6,7,5}, 4, 5);
		}

		@Test (expected=AssertionError.class)
		public void testAssertionErrorOnAdjacent(){
			ArrOperation.fixXY(new int[]{1,2,3,4,4,6,7,5}, 4, 5);
		}
	}
	
	public static class testNegativeTestCase{
		@Test
		public void testClumps(){
			int ans=ArrOperation.countClumps(new int[]{1,1,2,3});
			assertNotEquals(4, ans);
		}
		
		@Test
		public void testMaxMirrors(){
			int ans=ArrOperation.maxMirror(new int[]{1,1,2,3});
			assertNotEquals(4, ans);
		}
		
		@Test
		public void testSplitArray(){
			int ans=ArrOperation.splitArray(new int[]{1,1,2,3});
			assertNotEquals(4, ans);
		}
		
		@Test
		public void testFixXY(){
			int ans[]=ArrOperation.fixXY(new int[]{1,2,5,4,6,7,8},5,6);
			assertNotEquals(new int[]{1,2,4,6,5,7,8}, ans);
			
		}
	}
}
