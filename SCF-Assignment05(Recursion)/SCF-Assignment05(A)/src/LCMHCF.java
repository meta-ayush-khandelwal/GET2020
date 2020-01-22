public class LCMHCF {

	public static int hcf(int X,int Y){
		if (Y == 0) 
			return X; 
		else
			return hcf(Y, X % Y);  
	}
	
	public static int lcm(int X,int Y){
		return (X*Y)/hcf(X, Y);
	}
}
