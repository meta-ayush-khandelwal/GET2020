import java.util.*;

public class Marksheet {
	/** sc it is the object of Scanner class */
	static Scanner sc = new Scanner(System.in);

	/**
	 * it is a method to get no of students from user as input
	 * @return students it returns the no of students entered by the user
	 */
	public static int getNoOfStudents(){
		System.out.print("Enter the no of students:");
		int students= sc.nextInt();
		if(students<=0){
			System.out.println("Enter no of Students greater than zero");
			getNoOfStudents();
		}
		return students;
	}

	/**
	 * it is a method to get grades from user as input
	 * @param noOfStudents it have the total no of students
	 * @return grades it return the array of grades
	 */
	public static float[] getGrades(int noOfStudents){
		float grades[] =new float[noOfStudents];
		System.out.println("Enter the Grades of Students:");
		for(int loop=0;loop<noOfStudents;loop++){
			System.out.print("Enter the grade for Student "+(loop+1)+":");
			grades[loop]=sc.nextFloat();
			if(grades[loop]<0||grades[loop]>100){
				System.out.println("Enter valid grade(Grades can be between 0 and 100 both inclusive)");
				loop--;
			}
		}
		return grades;
	}
	
	/**
	 * it is a method to get grade average
	 * @param grades it is an array which have grades of students
	 * @return it return the average of grades in float
	 */
	public static float gradeAverage(float grades[]){
		float sum=0;
		for(int loop=0;loop<grades.length;loop++){
			sum+=grades[loop];
		}
		return (sum/grades.length);
	}

	/**
	 * it is a method to get minimum and maximum of grade
	 * @param grades it is an array which have grades of students
	 * @return minMax it return the array which have minimum and maximum grade 
	 */
	public static float[] minMaxGrade(float grades[]){
		float minMax[]={101,0};
		for(int loop=0;loop<grades.length;loop++){
			if(minMax[0]>grades[loop])
				minMax[0]=grades[loop];
			if(minMax[1]<grades[loop])
				minMax[1]=grades[loop];

		}
		return minMax;
	}

	/**
	 * it is a method to get percentage of pass students
	 * @param grades it is an array which have grades of students
	 * @return it return the percenatge of pass students
	 */
	public static float passStudentsPercentage(float grades[]){
		int passStudents=0;
		for(int loop=0;loop<grades.length;loop++){
			if(grades[loop]>=40)
				passStudents++;
		}
		return ((passStudents*100)/grades.length);
	}

	public static void main(String[] args) {
		try{
			/** noOfStudents it store the no of students */
			int noOfStudents=getNoOfStudents();
			/** grades it store the grades of students */
			float grades[]=getGrades(noOfStudents);
			System.out.println("Average of all grades:"+ gradeAverage(grades));
			System.out.println("Maximum of all grade:"+minMaxGrade(grades)[1]);
			System.out.println("Minimum of all grade:"+minMaxGrade(grades)[0]);
			System.out.println("Percentage of pass students:"+passStudentsPercentage(grades)+"%");
		}
		catch(InputMismatchException e){
			System.out.println("Please enter correct type of data");
			sc.nextLine();
			main(null);
		}
	}
}
