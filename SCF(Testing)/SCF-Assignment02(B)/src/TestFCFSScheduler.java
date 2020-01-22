import org.junit.Test;

import static org.junit.Assert.*;
public class TestFCFSScheduler {
	int[][] arrivalTime_BurstTime={{2,4},{3,5},{4,6},{5,8}};;
	int[] completionTime={6,11,17,25};
	int[] waitingTime={0,3,7,12};
	int[] turnAroundTime={4,8,13,20};
	float averageWaitingTime=5.50f;
	int maxWaitingTime=12;
	int noOfProcess=4;
	FCFSScheduler obj=new FCFSScheduler();
	
	@Test
	public void testAvgWaitingTime(){
		float ans=FCFSScheduler.calculateAverageWaitingTime(noOfProcess, waitingTime);
		assertEquals(averageWaitingTime, ans,0.009);
	}
	
	@Test
	public void testMaxWaitingTime(){
		float ans=FCFSScheduler.calculateMaxWaitingTime(noOfProcess, waitingTime);
		assertEquals(maxWaitingTime, ans,0.009);
	}
	
	@Test
	public void testCompletionTime(){
		int[] ans=FCFSScheduler.calculateCompletionTime(noOfProcess, arrivalTime_BurstTime);
		assertArrayEquals(completionTime,ans);
	}
	
	@Test
	public void testTurnAroundTime(){
		int[] ans=FCFSScheduler.calculateTurnAroundTime(noOfProcess, arrivalTime_BurstTime, waitingTime);
		assertArrayEquals(turnAroundTime,ans);
	}
	
	@Test
	public void testWaitingTime(){
		int[] ans=FCFSScheduler.calculateWaitingTime(noOfProcess, arrivalTime_BurstTime, completionTime);
		assertArrayEquals(waitingTime,ans);
	}
	
	@Test
	public void negativeTestWaitingTime(){
		int[] ans=FCFSScheduler.calculateWaitingTime(noOfProcess, arrivalTime_BurstTime, completionTime);
		assertNotEquals(new int[]{0,5,8,10},ans);
	}
	
	@Test
	public void negativeTestAvgWaitingTime(){
		float ans=FCFSScheduler.calculateAverageWaitingTime(noOfProcess, waitingTime);
		assertNotEquals(5.0f, ans,0.009);
	}
	
	@Test
	public void negativeTestMaxWaitingTime(){
		float ans=FCFSScheduler.calculateMaxWaitingTime(noOfProcess, waitingTime);
		assertNotEquals(4.0f, ans);
	}
	
	@Test
	public void negativeTestCompletionTime(){
		int[] ans=FCFSScheduler.calculateCompletionTime(noOfProcess, arrivalTime_BurstTime);
		assertNotEquals(new int[]{6,10,12,18},ans);
	}
	
	@Test
	public void negativeTestTurnAroundTime(){
		int[] ans=FCFSScheduler.calculateTurnAroundTime(noOfProcess, arrivalTime_BurstTime, waitingTime);
		assertNotEquals(new int[]{5,11,15,19},ans);
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionAvgWaitingTime(){
		FCFSScheduler.calculateAverageWaitingTime(noOfProcess,new int[]{});
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionMaxWaitingTime(){
		FCFSScheduler.calculateMaxWaitingTime(0, waitingTime);
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionCompletionTime(){
		FCFSScheduler.calculateCompletionTime(0, arrivalTime_BurstTime);
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionTurnAroundTime(){
		FCFSScheduler.calculateTurnAroundTime(noOfProcess,new int[][]{}, waitingTime);
	}
	
	@Test (expected=NullPointerException.class)
	public void testExceptionWaitingTime(){
		FCFSScheduler.calculateWaitingTime(noOfProcess, arrivalTime_BurstTime, new int[]{});
	}
}
