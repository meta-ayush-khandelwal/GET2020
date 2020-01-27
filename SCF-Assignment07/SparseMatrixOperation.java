
public class SparseMatrixOperation {
	private int[][] matrixPoint;
	private int count=0;
	private int column;
	private int row;
	
	public SparseMatrixOperation(int[][] inputMatrix) {

		if(inputMatrix.length==0)
			throw new AssertionError();

		row=inputMatrix.length;
		matrixPoint=new int[(inputMatrix.length)*(inputMatrix[0].length)][3];
		column=inputMatrix[0].length;

		for(int  i=0;i<row;i++){

			if(inputMatrix[i].length!=column)
				throw new AssertionError();

			for(int j=0;j<column;j++){

				if(inputMatrix[i][j]!=0){
					matrixPoint[count][0]=i;
					matrixPoint[count][1]=j;
					matrixPoint[count][2]=inputMatrix[i][j];
					count++;
				}
			}
		}
		if(((inputMatrix.length)*(inputMatrix[0].length))/2<count)
			throw new AssertionError();
	}

	public int[][] transposeMatrix(){
		int[][]result;
		if(row==column)
			result=new int[row][column];
		else
			result=new int[column][row];
		for(int i=0;i<count;i++){
			result[matrixPoint[i][1]][matrixPoint[i][0]]=matrixPoint[i][2];
		}
		return result;
	}

	public boolean checkSymmetrical(){
		if(row!=transposeMatrix().length||column!=transposeMatrix()[0].length){
			return false;
		}
		/*		for(int i=0;i<row;i++){
					for(int j=0;j<column;j++){
						if(inputMatrix[i][j]!=transposeMatrix()[i][j])
							return false;
					}
				}
		 */
		SparseMatrixOperation obj=new SparseMatrixOperation(transposeMatrix());
		boolean flag=true;
		for(int i=0;i<count;i++){

			if(matrixPoint[count][0]==obj.matrixPoint[count][0] 
					&& matrixPoint[count][1]==obj.matrixPoint[count][1] 
							&& matrixPoint[count][2]==obj.matrixPoint[count][2] 
					){
				flag=true;
			}
			else {
				flag= false;
				break;
			}
		}
		return flag;
	}

	public static int[][] addMatrix(SparseMatrixOperation firstMatrix,
			SparseMatrixOperation secondMatrix){

		int firstRows=firstMatrix.row;
		int firstColumns=firstMatrix.column;
		int secondRows=secondMatrix.row;
		int secondColumns=secondMatrix.column;

		if(firstColumns!=secondColumns||firstRows!=secondRows)
			throw new AssertionError();

		int[][]result=new int[firstRows][firstColumns];

		for(int i=0;i<firstMatrix.count;i++){
			result[firstMatrix.matrixPoint[i][0]]
					[firstMatrix.matrixPoint[i][1]]+=
					firstMatrix.matrixPoint[i][2];
		}

		for(int i=0;i<secondMatrix.count;i++){
			result[secondMatrix.matrixPoint[i][0]]
					[secondMatrix.matrixPoint[i][1]]+=
					secondMatrix.matrixPoint[i][2];
		}
		
		return result;
	}

	public static int[][] multiplyMatrix(SparseMatrixOperation firstMatrix,
			SparseMatrixOperation secondMatrix){
		int firstRows=firstMatrix.row;
		int firstColumns=firstMatrix.column;
		int secondRows=secondMatrix.row;
		int secondColumns=secondMatrix.column;
		if(firstColumns!=secondRows)
			throw new AssertionError();

		int[][]result=new int[firstRows][secondColumns];

		for(int i=0;i<firstMatrix.count;i++){
			for(int j=0;j<secondMatrix.count;j++){
				if(firstMatrix.matrixPoint[i][1]==secondMatrix.matrixPoint[j][0]){
					result[firstMatrix.matrixPoint[i][0]][secondMatrix.matrixPoint[j][1]]+=
							firstMatrix.matrixPoint[i][2]*secondMatrix.matrixPoint[j][2];
				}
			}
		}
		
		return result;
	}
}
