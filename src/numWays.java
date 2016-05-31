

public class numWays {
	
	public static long maxNumWays(int w,int h,String[] bad){
		long dp[][]=new long[w+1][h+1];
		for(int i=0;i<=w;i++){
			for(int j=0;j<=h;j++)
				dp[i][j]=-1;
		}
		for(int i=0;i<bad.length;i++){
			String[] temp = bad[i].split(" ");
			int a =Integer.valueOf(temp[3]);
			int b = Integer.valueOf(temp[2]);
			dp[a][b]=0;
		}
		for(int i=0;i<=w;i++){
			for(int j=0;j<=h;j++){
				if(dp[i][j]==0)
					continue;
				else{
					if(j>0 && i>0)
						dp[i][j]=dp[i-1][j]+dp[i][j-1];
					else if(j>0 && i==0)
						dp[i][j]=dp[i][j-1];
					else if(j==0 && i>0)
						dp[i][j]=dp[i-1][j];
					else
						dp[i][j]=1;
				}
			}
		}
		return dp[w][h];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h=6;
		int w=6;
		String[] bad={"0 0 0 1","6 6 5 6"};
		System.out.println(maxNumWays(w,h,bad));
	}

}
