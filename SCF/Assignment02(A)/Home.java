import java.util.InputMismatchException;
import java.util.Scanner;


public class Home {

	public static void main(String[] args) {
		int input=0;
		String result="";
		HexCalc calc=new HexCalc();
		Scanner sc = new Scanner(System.in);

		do{
			System.out.println("-----------HEXCALCULATOR-------------");
			System.out.println("\nSelect options:");
			System.out.println("1. Add Two Hexadecimal Number");
			System.out.println("2. Subtract Two Hexadecimal Number");
			System.out.println("3. Multiply Two Hexadecimal Number");
			System.out.println("4. Divide Two Hexadecimal Number");
			System.out.println("5. Check Two Hexadecimal Number is equal?");
			System.out.println("6. Check first hexadecimal number is greater than second hexadecimal number ");
			System.out.println("7. Check first hexadecimal number is lesser than second hexadecimal number");
			System.out.println("8. Change Decimal number into Hexadecimal number");
			System.out.println("9. Change HexaDecimal number into Decimal number");
			System.out.println("10. Exit");

			try{
				input = sc.nextInt();//it take the input from use to choose options
				switch (input) {
				case 1:
					calc.getValues();
					result=calc.addNumbers();
					if(calc.flag){
						if(calc.sign)
							System.out.println("Result is:"+result);
					}
					else{
						calc.flag=true;
					}
					break;
				case 2:
					calc.getValues();
					result=calc.subNumbers();
					if(calc.flag){
						if(calc.sign)
							System.out.println("Result is:"+result);
						else{
							System.out.println("Result is:-"+result);
							calc.sign=true;
						}
					}
					else{

						calc.flag=true;
					}
					break;
				case 3:
					calc.getValues();
					result=calc.multiplyNumbers();
					if(calc.flag){
						System.out.println("Result is:"+result);
					}
					else{

						calc.flag=true;
					}
					break;
				case 4:
					calc.getValues();
					result=calc.divideNumbers();
					if(calc.flag){
						if(calc.sign)
							System.out.println("Result is:"+result);
					}
					else{

						calc.sign=true;
						calc.flag=true;
					}
					break;
				case 5:
					calc.getValues();
					boolean equal= calc.equalNumbers();
					if(equal)
						System.out.println(equal);
					else if(!calc.flag&&!equal)
						calc.flag=true;
					else{
						System.out.println(equal);
						calc.flag=true;
					}
					break;
				case 6:
					calc.getValues();
					boolean great=calc.greaterNumber();
					if(great)
						System.out.println(great);
					else{
						calc.flag=true;
					}
					break;
				case 7:
					calc.getValues();
					boolean less=calc.lesserNumber();
					if(calc.flag)
						System.out.println(less);
					else{
						calc.flag=true;
					}
					break;
				case 8:
					String value=calc.decimalToHex(calc.getInput());
					if(calc.flag)
						System.out.println("Result is:"+value);	
					else
						calc.flag=true;
					break;
				case 9:
					long res=calc.hexToDecimal(calc.hexInput());
					if(calc.flag)
						System.out.println("Result is:"+res);
					else
						calc.flag= true;
					break;
				case 10:
					System.exit(0);
					break;
				default:
					//default message on choosing wrong choice
					System.out.println("Invalid choice. Please enter again !");
					break;
				}
			}
			catch(InputMismatchException e){
				//handle the exception on wrong type of data
				//Prints a message on entering wrong type of data
				System.out.println("You Have Entered Wrong Type of Data");
				sc.nextLine();
			}

		}while(input!=10);
		sc.close();
	}
}