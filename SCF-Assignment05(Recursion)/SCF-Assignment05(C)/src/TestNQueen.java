import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestNQueen {
	/**
	 * This method is used to test the nQueen function of NQueen Class.
	 */
	@Test
	public void testForNQueens()
	{
		NQueen obj = new NQueen();
		boolean result = obj.nOueen(new int[][] {
												{0,0,0,0},
												{0,0,0,0},
												{0,0,0,0},
												{0,0,0,0}},
												0,4);
		if(result)
		{
			obj.print(4);
		}
		assertEquals(true, result);
		
	}
	
	@Test
	public void testForNQueens1()
	{
		NQueen obj = new NQueen();
		boolean result = obj.nOueen(new int[][] {
												{0,0,0,0,0,0,0,0},
												{0,0,0,0,0,0,0,0},
												{0,0,0,0,0,0,0,0},
												{0,0,0,0,0,0,0,0},
												{0,0,0,0,0,0,0,0},
												{0,0,0,0,0,0,0,0},
												{0,0,0,0,0,0,0,0},
												{0,0,0,0,0,0,0,0}},
												0,8);
		if(result)
		{
			obj.print(8);
		}
		assertEquals(true, result);
		
	}
	
	

}
