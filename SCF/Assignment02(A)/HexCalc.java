import java.util.InputMismatchException;
import java.util.Scanner;

public class HexCalc {
	String firstNumber,secondNumber;
	Scanner sc= new Scanner(System.in);
	boolean sign=true,flag=true;
	long number;
	int base;
	String baseName;
	final int num=48;

	boolean getValues(){
		System.out.println("Enter the First Number");		
		firstNumber=sc.next();
		if(checkHexValue(firstNumber)){	
			System.out.println("Enter the Second Number");
			secondNumber=sc.next();
			if(!checkHexValue(secondNumber))
				getValues();
		}
		else{
			getValues();
		}
		return true;
	}

	boolean getBase(){
		System.out.print("Enter Base:");
		base=sc.nextInt();
		if(base==2||base==8||base==16){

			if(base==2)
				baseName="Binary";
			else if(base==8)
				baseName="Octal";
			else if(base==16)
				baseName="HexaDecimal";
			return true;
		}
		else{
			System.out.println("Error!!! Enter Correct Base(2 or 8 or 16)");
			getBase();
		}
		return true;
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
			rem=(int)(number%base);   
			hexNumber=hexchars[rem]+hexNumber;   
			number=number/base;  
		}      
		return hexNumber;
	}

	long hexToDecimal(String number){
		long decimalNumber=0;
		long[] a= new long[number.length()];
		for(int i=0;i<number.length();i++){
			long c=(long)number.charAt(i);
			if(c>=num && c<=(num+base-1)){
				a[number.length()-1-i]=c-num;
			}
			else if(c>=65 && c<=70 && base==16){
				a[number.length()-1-i]=c-55;
			}
			else if(c>=97 && c<=102 && base==16){
				a[number.length()-1-i]=c-87;
			}
			else{
				System.out.println("Wrong format entered");
				flag=false;
				return -1;
			}
		}
		for(int i=0;i<a.length;i++){
			decimalNumber+=(a[i]*(int)Math.pow(base,i));
		}
		return decimalNumber;
	}



	boolean checkHexValue(String number){
		boolean res=true;
		for(int i=0;i<number.length();i++){
			int c=(int)number.charAt(i);
			if(c>=num && c<=(num+base-1)){
				res=true;
			}
			else if(c>=65 && c<=70 && base==16){
				res=true;
			}
			else if(c>=97 && c<=102 && base==16){
				res= true;
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
		int firstLength=numberFirst.length();
		int secondLength=numberSecond.length();
		if(firstLength==secondLength){
			for(int i=0;i<firstLength;i++){
				if((int)Character.toLowerCase(numberFirst.charAt(i))>(int)Character.toLowerCase(numberSecond.toLowerCase().charAt(i))){
					return true;
				}
			}
		}
		else if(firstLength>secondLength)
			return true;
		else{
			return false;
		}
		flag=false;
		return false;

	}

	boolean lesserNumber(){
		String numberFirst=perfectNumber(this.firstNumber);
		String numberSecond=perfectNumber(this.secondNumber);
		System.out.println(numberFirst);
		System.out.println(numberSecond);
		int firstLength=numberFirst.length();
		int secondLength=numberSecond.length();
		if(firstLength==secondLength){
			for(int i=0;i<firstLength;i++){
				if((int)Character.toLowerCase(numberFirst.charAt(i))>(int)Character.toLowerCase(numberSecond.toLowerCase().charAt(i))){
					return false;
				}
			}
		}
		else if(firstLength<secondLength)
			return true;
		else {
			return false;
		}
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
					if((int)Character.toLowerCase(numberFirst.charAt(i))!=(int)Character.toLowerCase(numberSecond.toLowerCase().charAt(i)))
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
