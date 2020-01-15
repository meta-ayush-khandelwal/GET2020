import java.util.InputMismatchException;
import java.util.Scanner;

public class HexCalc {
	String firstNumber,secondNumber;
	Scanner sc= new Scanner(System.in);
	boolean sign=true,flag=true;
	long number;

	void getValues(){
		System.out.println("Enter the First Number");		
		firstNumber=sc.next();
		//sc.nextLine();
		System.out.println("Enter the Second Number");
		secondNumber=sc.next();
	}

	long getInput(){
		System.out.println("Enter the Number");
		try{
			number=sc.nextLong();
		}
		catch(InputMismatchException e){
			System.out.println("Error! Wrong Data Entered");
			sc.nextLine();
			flag=false;
			number=0;
		}
		return number;
	}

	String hexInput(){
		System.out.println("Enter the Number");
		//sc.next();
		String number=sc.next();
		sc.nextLine();
		return number;
	}

	String addNumbers(){
		long first=hexToDecimal(firstNumber);
		long second=hexToDecimal(secondNumber);
		long result= first+second;
		return decimalToHex(result);
	}

	String subNumbers(){
		long first=hexToDecimal(firstNumber);
		long second=hexToDecimal(secondNumber);
		long result= first-second;
		if(second>first){
			sign=false;
			result=result*(-1);
		}
		return decimalToHex(result);
	}

	String multiplyNumbers(){
		long first=hexToDecimal(firstNumber);
		long second=hexToDecimal(secondNumber);
		long result= first*second;
		return decimalToHex(result);
	}

	String divideNumbers(){
		long first=hexToDecimal(firstNumber);
		long second=hexToDecimal(secondNumber);
		//System.out.println(flag);
		if(!flag){
			return "";
		}
		else if(second==0 && flag){
			flag=false;
			return "Second number can't be negative for division";
		}
		else{
			long result= first/second;
			String remainder=decimalToHex(first-(second*result));
			String answer=decimalToHex(result);
			return answer+" Remainder is:"+remainder;
		}
	}

	String decimalToHex(long number){    
		int rem;  
		String hexNumber="";   
		char hexchars[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		if(number==0)
			return "0";
		while(number>0)  
		{  
			rem=(int)(number%16);   
			hexNumber=hexchars[rem]+hexNumber;   
			number=number/16;  
		}      
		return hexNumber;
	}

	long hexToDecimal(String number){
		long decimalNumber=0;
		long[] a= new long[number.length()];
		for(int i=0;i<number.length();i++){
			long c=(long)number.charAt(i);
			if(c>=48 && c<=57){
				a[number.length()-1-i]=c-48;
			}
			else if(c>=65 && c<=70){
				a[number.length()-1-i]=c-55;
			}
			else if(c>=97 && c<=102){
				a[number.length()-1-i]=c-87;
			}
			else{
				System.out.println("Wrong format entered");
				flag=false;
				return -1;
			}
		}
		for(int i=0;i<a.length;i++){
			decimalNumber+=(a[i]*(int)Math.pow(16,i));
		}
		return decimalNumber;
	}

	boolean checkHexValue(String number){
		boolean res=true;
		for(int i=0;i<number.length();i++){
			int c=(int)number.charAt(i);
			if(c>=48 && c<=57){
				res=true;
			}
			else if(c>=65 && c<=70){
				res=true;
			}
			else if(c>=97 && c<=102){
				res=true;
			}
			else{
				System.out.println("Wrong format entered");
				res=false;
				break;
			}
		}
		return res;
	}

	boolean greaterNumber(){
		String numberFirst=perfectNumber(this.firstNumber);
		String numberSecond=perfectNumber(this.secondNumber);
		if(checkHexValue(numberFirst)&&checkHexValue(numberSecond)){
			int firstLength=numberFirst.length();
			int secondLength=numberSecond.length();
			if(firstLength==secondLength){
				for(int i=0;i<firstLength;i++){
					if((int)numberFirst.toLowerCase().charAt(i)>(int)numberSecond.toLowerCase().charAt(i)){
						return true;
					}
				}
			}
			else{
				int size=firstLength;
				if(firstLength<secondLength)
					size=secondLength;
				for(int i=0;i<size;i++){
					if((int)numberFirst.toLowerCase().charAt(i)>(int)numberSecond.toLowerCase().charAt(i)){
						if(numberFirst.substring(i,firstLength).length()>numberSecond.substring(i, secondLength).length()){
							return true;	
						}
						else
							return false;
					}
					else if((int)numberFirst.toLowerCase().charAt(i)<(int)numberSecond.toLowerCase().charAt(i)){
						if(numberFirst.substring(i,firstLength).length()>numberSecond.substring(i, secondLength).length()){
							return true;	
						}
						else
							return false;
					}
				}
			}
		}
		else
			flag=false;
		return false;

	}

	boolean lesserNumber(){
		String numberFirst=perfectNumber(this.firstNumber);
		String numberSecond=perfectNumber(this.secondNumber);
		if(checkHexValue(numberFirst)&&checkHexValue(numberSecond)){
			int firstLength=numberFirst.length();
			int secondLength=numberSecond.length();
			if(firstLength==secondLength){
				for(int i=0;i<firstLength;i++){
					if((int)numberFirst.toLowerCase().charAt(i)>(int)numberSecond.toLowerCase().charAt(i)){
						return false;
					}
				}
			}
			else{
				int size=firstLength;
				if(firstLength<secondLength)
					size=secondLength;
				for(int i=0;i<size;i++){
					if((int)numberFirst.toLowerCase().charAt(i)>(int)numberSecond.toLowerCase().charAt(i)){
						if(numberFirst.substring(i,firstLength).length()>numberSecond.substring(i, secondLength).length()){
							return false;	
						}
						else
							return true;
					}
					else if((int)numberFirst.toLowerCase().charAt(i)<(int)numberSecond.toLowerCase().charAt(i)){
						if(numberFirst.substring(i,firstLength).length()>numberSecond.substring(i, secondLength).length()){
							return false;	
						}
						else
							return true;
					}
				}
			}
		}
		else 
			flag=false;
		return true;
	}

	String perfectNumber(String number){
		String perfectNumber="";
		for(int i=0;i<number.length();i++){
			if(number.charAt(i)=='0'){
				perfectNumber=number.substring(i, number.length());
			}
			else if(number.charAt(i)!='0'){
				perfectNumber=number.substring(i,number.length());
				break;
			}
		}
		return perfectNumber;
	}

	boolean equalNumbers(){
		String numberFirst=perfectNumber(this.firstNumber);
		String numberSecond=perfectNumber(this.secondNumber);
		boolean res=true;
		if(checkHexValue(numberFirst)&&checkHexValue(numberSecond)){
			int firstLength=numberFirst.length();
			int secondLength=numberSecond.length();
			if(firstLength!=secondLength)
				res= false;
			else{
				for(int i=0;i<firstLength;i++){
					if((int)numberFirst.toLowerCase().charAt(i)>(int)numberSecond.toLowerCase().charAt(i)){
						res= false;
					}
					else if((int)numberFirst.toLowerCase().charAt(i)<(int)numberSecond.toLowerCase().charAt(i))
						res= false;
				}
			}
		}
		else{
			res=false;
			flag=false;
		}
		return res;
	}
}
