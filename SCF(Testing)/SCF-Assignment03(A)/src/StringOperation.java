import java.util.*;
public class StringOperation {
	/** sc it is the object of Scanner class */
	Scanner sc=new Scanner(System.in);
	/** it is a method to get inputs from user */
	void getString(){
		System.out.println("Enter the String");
		Home.firstString=sc.nextLine();
		if(Home.input==1){
			System.out.println("Enter another String");
			Home.secondString=sc.nextLine();
		}
	}
	
	/**
	 * it is a method to compare two String
	 * @param first it have the first string
	 * @param second it have the second string
	 * @return it returns 1 on equal string and 0 on unequal string
	 */
	int stringCompare(String first,String second){
		if(first.isEmpty()||second.isEmpty())
			throw new NullPointerException();
		int firstLength=first.length();
		int secondLength=second.length();
		if(firstLength!=secondLength)
			return 0;
		else{
			for(int loop=0;loop<firstLength;loop++){
				if(first.charAt(loop)!=second.charAt(loop))
					return 0;
			}
		}
		return 1;
	}
	
	/**
	 * it is a method to reverse the String
	 * @param string it have the string which will reversed
	 * @return result it returns resversed string 
	 */
	String stringReverse(String string){
		if(string.isEmpty())
			throw new NullPointerException();
		String result="";
		for(int loop=string.length()-1;loop>=0;loop--){
			result+=string.charAt(loop);
		}
		return result;
	}

	/**
	 * it is a method to convert upper case character into lower case and lower case into upper case
	 * @param string it have the string as input
	 * @return result it returns output string 
	 */
	String stringCaseConvertor(String string){
		if(string.isEmpty())
			throw new NullPointerException();
		String result="";
		for(int loop=0;loop<string.length();loop++){
			if(string.charAt(loop)>='A' && string.charAt(loop)<='Z')
				result+=(char)(string.charAt(loop)+32);
			else if(string.charAt(loop)>='a' && string.charAt(loop)<='z')
				result+=(char)(string.charAt(loop)-32);
			else
				result+=string.charAt(loop);
		}
		return result;
	}

	/**
	 * it is a method to find the largest word in a string
	 * @param string it have the string as input in which the largest word will check
	 * @return result it returns largest word of string
	 */
	String largestWord(String string){
		if(string.isEmpty())
			throw new NullPointerException();
		String result="",tempResult="";
		int length=0;
		for(int loop=0;loop<string.length();loop++){
			if((int)string.charAt(loop)==32){
				if(tempResult.length()>=length){
					result=tempResult;
					length=tempResult.length();
					tempResult="";
				}
				else
					tempResult="";
			}
			else{
				tempResult+=string.charAt(loop);
			}
		}
		if(result.length()<=tempResult.length())
			result=tempResult;
		return result;
	}
}
