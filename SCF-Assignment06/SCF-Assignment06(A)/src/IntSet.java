final public class IntSet {
	private final int[] universalSet=new int[1001];
	private final int []set;

	IntSet(int[] inputSet){
		int count=0;
		int[] tempSet;
		if(checkInput(inputSet)){
			tempSet=new int[inputSet.length];
			for(int loop=0;loop<inputSet.length;loop++){
				if(universalSet[inputSet[loop]]!=1){
					universalSet[inputSet[loop]]=1;
					count++;
					tempSet[loop]=inputSet[loop];
				}
				else if(universalSet[inputSet[loop]]==1)
					throw new RuntimeException("Incorrect Input");
			}
		}
		else
			throw new RuntimeException("Incorrect Input");
		set=new int[count];
		for(int loop=0;loop<count;loop++){
			set[loop]=tempSet[loop];
		}
	}

	public boolean checkInput(int[]input){
		for(int loop=0;loop<input.length;loop++){
			if(input[loop]<0||input[loop]>1000)
				return false;
		}
		return true;
	}

	public boolean isMember(int X){
		for(int loop=0;loop<set.length;loop++){
			if(set[loop]==X)
				return true;
		}
		return false;	
	}

	public int size(){
		return set.length;
	}

	public boolean isSubSet(IntSet s){
		for (int i = 0; i < s.set.length; i++) {
			if (!isMember(s.set[i])) {
				return false;
			}
		}
		return true;
	}

	public int[] getComplement(){
		int j=0;
		int[] resultSet=new int[1000-size()];
		for(int i=1;i<=1000;i++){
			if(universalSet[i]!=1){
				resultSet[j]=i;
				j++;
			}
		}
		return resultSet;
	}

	public int[] union(IntSet s1,IntSet s2){
		int[] resultSet;
		int[] tempSet=new int[s1.size()+s2.size()];
		int count=0;
		for(int i=0;i<s1.size();i++){
			tempSet[count]=s1.set[i];
			count++;
		}
		for(int j=0;j<s2.size();j++){
			if(s1.universalSet[s2.set[j]]!=1){
				tempSet[count]=s2.set[j];
				count++;
			}

		}
		resultSet=new int[count];
		for(int i=0;i<count;i++)
			resultSet[i]=tempSet[i];
		return resultSet;
	}
}
