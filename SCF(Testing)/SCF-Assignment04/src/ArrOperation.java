public class ArrOperation {

	/**
	 * it is a method to count the clumps in an array.
	 * @param inputArray it is array of integer inputs
	 * @return clumps it return the no of clumps.
	 */
	public static int countClumps(int inputArray[]){
		if(inputArray.length==0)
			throw new AssertionError();
		int count=0,clumps=0;
		for(int loop=0;loop<inputArray.length-1;loop++){
			if(inputArray[loop]==inputArray[loop+1])
				count++;
			else 
				count=0;
			if(count==1)
				clumps++;
		}
		return clumps;
	}

	/**
	 * it is a method to find index to split an array such as both side sum are equal.
	 * @param inputArray it is array of integer inputs
	 * @return it return the index if split possible otherwise return -1.
	 */
	public static int splitArray(int inputArray[]){
		if(inputArray.length==0)
			throw new AssertionError();
		int sum=0,leftSum=0;
		for(int loop=0;loop<inputArray.length;loop++){
			sum+=inputArray[loop];
		}
		for(int loop=0;loop<inputArray.length;loop++){
			leftSum+=inputArray[loop];
			if(sum-leftSum==leftSum)
				return ++loop;
		}
		return -1;	
	}

	/**
	 * it is a method to count max mirror in an array.
	 * @param inputArray it is array of integer inputs
	 * @return max it return the no of mirrors.
	 */
	public static int maxMirror(int inputArray[]){	
		int count=0,max=0;
		boolean flag=true;
		if(inputArray.length==0)
			throw new AssertionError();
		for(int i=0;i<inputArray.length;i++){
			int frontPoint=i,backPoint=inputArray.length-1;
			for(int j=inputArray.length-1;j>=0;j--){
				if(backPoint>=0 && frontPoint<=inputArray.length-1){
					if(inputArray[frontPoint]==inputArray[backPoint]){
						//System.out.println(frontPoint);
						//System.out.println(backPoint);
						count++;
						frontPoint++;
						backPoint--;
						//System.out.println(count);
					}
					else{
						count=0;
						backPoint--;
					}
					if(frontPoint>=inputArray.length){
						flag=false;
						break;
					}
				}
			}
			if(max<count)
				max=count;
			if(!flag)
				break;
		}
		return max;
	}

	/**
	 * it is a method to fix XY problem.
	 * @param inputArray it is array of integer inputs
	 * @param X it is the X for the problem which is non movable in array.
	 * @param Y it is Y for the problem which is movable in array.
	 * @return it returns the array after fix XY problem.
	 */
	public static int[] fixXY(int inputArray[],int X, int Y){
		int l=0,j=0,m=0;
		int countX=0,countY=0;
		int tempArray[]=inputArray;
		int yIndex[]=new int[inputArray.length];
		int xIndex[]=new int[inputArray.length];
		if(inputArray.length==0)
			throw new AssertionError();
		if(inputArray[inputArray.length-1]==X)
			throw new AssertionError();
		for(int loop=0;loop<tempArray.length;loop++){
			if(tempArray[loop]==Y){
				yIndex[l]=loop;
				l++;
				countY++;
			}
			if(tempArray[loop]==X){
				countX++;
				xIndex[m]=loop;
				if(m!=0 && xIndex[m-1]+1==xIndex[m])
					throw new AssertionError();
				m++;
			}
		}
		if(countX!=countY)
			throw new AssertionError();

		for(int i=0;i<=tempArray.length-1;i++){
			if(tempArray[i]==X && tempArray[i+1]!=X && tempArray[i+1]!=Y){
				int temp=tempArray[i+1];
				tempArray[i+1]=Y;
				tempArray[yIndex[j]]=temp;
				j++;
			}
		}
		return tempArray;
	}

	public static void main(String args[]){
		int []arr=new int[]{1, 4, 1, 5, 5, 4, 1};
		for(int i=0;i<arr.length;i++)
			System.out.println(fixXY(arr, 4, 5)[i]);
	}
}
