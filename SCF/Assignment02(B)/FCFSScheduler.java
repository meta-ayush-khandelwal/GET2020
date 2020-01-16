import java.util.*;

public class FCFSScheduler {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of process");
		int[][] arrivalTime_BurstTime;
		int[] completionTime;
		int[] waitingTime;
		int[] turnAroundTime;
		float averageWaitingTime;
		int maxWaitingTime;
		int noOfProcess;

		try{
			noOfProcess=sc.nextInt();
			if(noOfProcess<=0){
				System.out.println("Number of processes can't be negative nor zero");
				System.exit(0);
			}

			arrivalTime_BurstTime= new int[noOfProcess][2];
			completionTime=new int[noOfProcess];
			waitingTime=new int[noOfProcess];
			turnAroundTime=new int[noOfProcess];
			System.out.println("Enter the arrival and time burst time for each process");
			
			for(int i=0;i<noOfProcess;i++){
				System.out.println("Enter for the process :"+(i+1));
				for(int j=0; j<2; j++){
					arrivalTime_BurstTime[i][j]=sc.nextInt();
				}
			}
		}
		catch(InputMismatchException e){
			System.out.println("Wrong Data Entered");
			return;
		}

		for(int i=0;i< noOfProcess;i++){
			for(int j=0;j<noOfProcess-1-i;j++){
				if(arrivalTime_BurstTime[j][0]>arrivalTime_BurstTime[j+1][0]){
					int temp1,temp2;
					temp1=arrivalTime_BurstTime[j][0];
					temp2=arrivalTime_BurstTime[j][1];

					arrivalTime_BurstTime[j][0]=arrivalTime_BurstTime[j+1][0];
					arrivalTime_BurstTime[j][1]=arrivalTime_BurstTime[j+1][1];

					arrivalTime_BurstTime[j+1][0]=temp1;
					arrivalTime_BurstTime[j+1][1]=temp2;
				}
			}
		}

		completionTime=calculateCompletionTime(noOfProcess,arrivalTime_BurstTime);//calculation of completion time
		waitingTime=calculateWaitingTime(noOfProcess,arrivalTime_BurstTime,completionTime);//calculation of waiting time
		turnAroundTime=calculateTurnAroundTime(noOfProcess,arrivalTime_BurstTime,waitingTime);//calculation of turn around time
		averageWaitingTime=calculateAverageWaitingTime(noOfProcess,waitingTime);//initializing the value
		maxWaitingTime=calculateMaxWaitingTime(noOfProcess,waitingTime);//initializing the value
		display(noOfProcess,arrivalTime_BurstTime,completionTime,waitingTime,turnAroundTime,averageWaitingTime,maxWaitingTime);
	}

	public static int[] calculateCompletionTime(int noOfProcess, int[][] arrivalTime_BurstTime){
		int[] completionTime=new int[noOfProcess];
		completionTime[0]=arrivalTime_BurstTime[0][1]+arrivalTime_BurstTime[0][0];
		for (int i=1;i<noOfProcess;i++){
			if(arrivalTime_BurstTime[i][0]<completionTime[i-1]){
				completionTime[i]=completionTime[i-1]+arrivalTime_BurstTime[i][1];
			}
			else{
				completionTime[i]=arrivalTime_BurstTime[i][0]+arrivalTime_BurstTime[i][1];
			}
		}
		return completionTime;
	}

	public static int[] calculateWaitingTime(int noOfProcess, int[][] arrivalTime_BurstTime, int[] completionTime){
		int[] waitingTime=new int[noOfProcess];
		waitingTime[0]=0;
		for (int i=1;i<noOfProcess;i++){
			if(arrivalTime_BurstTime[i][0]<completionTime[i-1]){
				waitingTime[i]=completionTime[i-1]-arrivalTime_BurstTime[i][0];
			}
			else{
				waitingTime[i]=0;
			}
		}
		return waitingTime;
	}

	public static int[] calculateTurnAroundTime(int noOfProcess, int[][] arrivalTime_BurstTime, int[] waitingTime){
		int[] turnAroundTime=new int[noOfProcess];
		for(int i=0;i<noOfProcess;i++){
			turnAroundTime[i]=arrivalTime_BurstTime[i][1]+waitingTime[i];
		}
		return turnAroundTime;
	}

	public static float calculateAverageWaitingTime(int noOfProcess, int[] waitingTime){
		float sumWaitingTime=0;
		for(int i=0; i<noOfProcess; i++){
			sumWaitingTime=sumWaitingTime+waitingTime[i];
		}
		float averageWaitingTime=sumWaitingTime/noOfProcess;
		return averageWaitingTime;
	}

	public static int calculateMaxWaitingTime(int noOfProcess, int[] waitingTime){
		int maxWaitingTime=0;
		for(int i=0; i<noOfProcess; i++){
			if(waitingTime[i]>maxWaitingTime){
				maxWaitingTime=waitingTime[i];
			}
		}
		return maxWaitingTime;
	}

	public static void display(int noOfProcess, int[][] arrivalTime_BurstTime, int[] completionTime, int[] waitingTime, int[] turnAroundTime, float averageWaitingTime, int maxWaitingTime){
		System.out.println("Arrival time\t\t\tBurst time\t\t\tCompletiontime\t\t\tWaitingTime\t\t\tTurnAroundTime");
		for(int i=0;i<noOfProcess;i++) {
			for(int j=0;j<2;j++){
				System.out.print(arrivalTime_BurstTime[i][j]+"\t\t\t\t");
			}
			System.out.print(completionTime[i]+"\t\t\t\t"+waitingTime[i]+"\t\t\t\t"+turnAroundTime[i]+"\n");
		}
		System.out.println("\nAverage Waiting Time: "+averageWaitingTime+"\nMaximum Waiting Time For Process: "+maxWaitingTime);
	}
}
