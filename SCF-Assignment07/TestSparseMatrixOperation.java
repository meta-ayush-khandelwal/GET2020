import static org.junit.Assert.*;
import org.junit.Test;

public class TestSparseMatrixOperation {

	@Test
	public void testTranspose(){
		SparseMatrixOperation obj=new SparseMatrixOperation(
				new int[][]{
						{0,0,4,8},
						{1,0,0,5},
						{0,0,0,0},
						{0,2,0,0}
				}
				);
		int res[][]=obj.transposeMatrix();
		int ans[][]=new int[][]{
				{0,1,0,0},
				{0,0,0,2},
				{4,0,0,0},
				{8,5,0,0}
		};
		assertArrayEquals(ans, res);
	}

	@Test
	public void testSymmetric(){
		SparseMatrixOperation obj=new SparseMatrixOperation(
				new int[][]{
						{1,0,0,1},
						{0,0,0,0},
						{0,0,0,0},
						{1,0,0,1}
				}
				);
		boolean result=obj.checkSymmetrical();
		assertEquals(true, result);
	}

	@Test
	public void testAddMatrix(){
		SparseMatrixOperation obj1=new SparseMatrixOperation(
				new int[][]{
						{0,0,4,8},
						{1,0,0,5},
						{0,0,0,0},
						{0,2,0,0}
				}
				);
		SparseMatrixOperation obj2=new SparseMatrixOperation(
				new int[][]{
						{2,0,4,7},
						{1,0,0,6},
						{0,0,5,0},
						{0,4,0,0}
				}
				);
		int ans[][]=new int[][]{
				{2,0,8,15},
				{2,0,0,11},
				{0,0,5,0},
				{0,6,0,0}
		};
		assertArrayEquals(ans, SparseMatrixOperation.addMatrix(obj1, obj2) );
	}

	@Test
	public void TestSparseMtrix_multiplyMatrix(){
		int[][] arr = new int[][]{
				{5,0,3},
				{2,0,0},
				{1,0,0}
		};
		SparseMatrixOperation s1 = new SparseMatrixOperation(arr);

		int[][] brr = new int[][]{
				{0,0,0,1},
				{2,3,0,0},
				{1,0,1,0}
		};
		SparseMatrixOperation s2 = new SparseMatrixOperation(brr);

		int[][] res = new int[][]{
				{3,0,3,5},
				{0,0,0,2},
				{0,0,0,1}
		};
		int[][] ans = SparseMatrixOperation.multiplyMatrix(s1, s2);
		assertArrayEquals(ans,res);
	}

}
