import java.util.Arrays;

public class BadNeighbour {
	public static int max(int a,int b){
		return a>b?a:b;
	}
	public static int donation(int[] d,int l,int u){
		int dp[] = new int[d.length];
		Arrays.fill(dp,d[l]);
		dp[l]=d[l];
		dp[l+1]=d[l+1];
		for(int i=l+2;i<=u;i++){
			dp[i]=max(dp[i-1],dp[i-2]+d[i]);
		}
		Arrays.sort(dp,l,u);
		return dp[u];
	}
	public static void main(String args[]){
		/*int d[] = 	
			{ 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
					  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
					  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };*/
		int d[] ={11,15};
		if(d.length>2)
			System.out.println(max(donation(d,0,d.length-2),donation(d,1,d.length-1)));
		else if(d.length==2)
			System.out.println(max(d[0],d[1]));
		else
			System.out.println(d[0]);
	}

}
