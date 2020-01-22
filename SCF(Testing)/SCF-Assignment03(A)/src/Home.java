import java.util.*;
public class Home {
	/** 
	 * firstString it store the first string entered by user as input
	 * secondString it store the second string entered by user as input 
	 */
	static String firstString,secondString;
	/** input it store the choice from options entered by user */
	static int input=0;
	public static void main(String args[]){
		/** operation object of StringOperation class */
		StringOperation operation=new StringOperation();
		/** sc it is the object of Scanner class */
		Scanner sc= new Scanner(System.in);
		do{
			System.out.println("-----------String Operations-------------");
			System.out.println("\nSelect options:");
			System.out.println("1. Compare Two Strings");
			System.out.println("2. Reverse of String");
			System.out.println("3. Replace the lower case into upper case and upper case into lowere case");
			System.out.println("4. Largest word of a String");
			System.out.println("5. Exit");
			try{
				input = sc.nextInt();//it take the input from use to choose options
				switch (input) {
				case 1:
					operation.getString();
					System.out.println(operation.stringCompare(firstString, secondString));
					break;
				case 2:
					operation.getString();	
					System.out.println(operation.stringReverse(firstString));
					break;
				case 3:
					operation.getString();
					System.out.println(operation.stringCaseConvertor(firstString));
					break;
				case 4:
					operation.getString();
					System.out.println(operation.largestWord(firstString));
					break;
			case 5:
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

		}while(input!=5);
		sc.close();
	}
}
