import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class TestSearch {
	@Test
	public void testLinearSearch(){
		//int inputArray[]=new int[]{3,2,4,5,6,2,7,1,8,15,13,12,11,6};
		int n=Search.linearSearch(new int[]{3,2,4,5,6,2,7,1,8,15,13,12,11,6},0, 99);
		assertEquals(-1, n);
		int b=Search.binarySearch(new int[]{2,3,4,6,7,8,9,11},0, 8, 2);
		assertEquals(0, b);
	}

}
