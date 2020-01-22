public class Search {

	public static int linearSearch(int inputArray[],int start,int find){
		if(inputArray[start]==find){
			return start;
		}
		else if(start+1==inputArray.length)
			return -1;
		else 
			return linearSearch(inputArray, start+1, find);
	}

	public static int binarySearch(int inputArray[],int start,int end,int find){
		if(end >= start) { 
			int mid = start + (end - start) / 2; 
			if(inputArray[mid] == find) 
				return mid; 
			if(inputArray[mid] > find) 
				return binarySearch(inputArray, start, mid - 1, find); 
			return binarySearch(inputArray, mid + 1, end, find); 
		} 
		return -1;
	}
}
