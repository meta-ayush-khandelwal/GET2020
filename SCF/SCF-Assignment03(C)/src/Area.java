import java.util.InputMismatchException;
import java.util.Scanner;

public class Area {
	/** sc it is the object of Scanner class */
	static Scanner sc = new Scanner(System.in);
	/** 
	 *  width it store the width
	 *  height it store the height
	 *  radius it store the radius
	 */
	static double width,height,radius;

	/**
	 * it is a method to get inputs from user
	 * @param choice it have the choice entered by user to get related input
	 */
	public static void getInputs(int choice){
		if(choice==1||choice==2){
			System.out.print("Enter the width:");
			width = sc.nextDouble();
			System.out.print("Enter the height:");
			height = sc.nextDouble();
			if(width<=0||height<=0){
				System.out.println("Enter valid Data(widht,height must be greater than zero)");
				sc.nextLine();
				getInputs(choice);
			}
		}
		else if(choice==3){
			System.out.print("Enter the width of square : ");
			width = sc.nextDouble();
			if(width<=0){
				System.out.println("Enter valid Data(widht must be greater than zero)");
				sc.nextLine();
				getInputs(choice);
			}
		}
		else if(choice==4){
			System.out.print("Enter the radius of circle : ");
			radius = sc.nextDouble();
			if(radius<=0){
				System.out.println("Enter valid Data(radius must be greater than zero)");
				sc.nextLine();
				getInputs(choice);
			}
		}
	}

	/**
	 * it is a method to calculate the area of triangle.
	 * @param width it have the width of triangle
	 * @param height it have the height of triangle
	 * @return it returns the area as double.
	 */
	public static double areaOfTriangle(double width,double height) {
		double area = (width * height) / 2;
		return area;

	}

	/**
	 * it is a method to calculate the area of rectangle.
	 * @param width it have the width of rectangle
	 * @param height it have the height of rectangle
	 * @return it returns the area as double.
	 */
	public static double areaOfRectangle(double width,double height) {
		double area = (width * height);
		return area;

	}

	/**
	 * it is a method to calculate the area of square.
	 * @param width it have the width of square
	 * @return it returns the area as double.
	 */
	public static double areaOfSquare(double width) {
		double area = (width * width);
		return area;

	}

	/**
	 * it is a method to calculate the area of circle.
	 * @param radius it have the radius of circle
	 * @return it returns the area as double.
	 */
	public static double areaOfCircle(double radius) {
		double area = ((22 * radius * radius) / 7);
		return area;

	}

	public static void main(String[] args) {
		/** choice it store the choice from options entered by user */
		int choice=0;
		do{
			System.out.println("Enter the choice");
			System.out.println("1. Area of Triangle");
			System.out.println("2. Area of Rectangle");
			System.out.println("3. Area of Square");
			System.out.println("4. Area of Circle");
			System.out.println("5. Exit");
			try {
				choice = sc.nextInt();
				getInputs(choice);
				switch (choice) {

				case 1:
					System.out.println("The area of Triangle is:"+ areaOfTriangle(width,height));
					break;

				case 2:
					System.out.println("The area of Rectangle is:"+ areaOfRectangle(width,height));
					break;

				case 3:
					System.out.println("The area of Square is:"+ areaOfSquare(width));
					break;

				case 4:
					System.out.println("The area of Circle is:"+ areaOfCircle(radius));
					break;

				case 5:
					System.exit(0);
					break;

				default:
					System.out.println("Invalid choice!!! Enter the correct choice");
					break;
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Enter the correct information");
				sc.nextLine();
				main(null);
			}

		}while(choice!=5);

	}

}
