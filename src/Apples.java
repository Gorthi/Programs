import java.util.Arrays;

public class Apples {
	
	public static int countMax(int[][] a){
		int rows=a.length;
		int columns=a[0].length;
		int dp[][] = new int[rows][columns];
		Arrays.fill(dp, 0);
		/*dp[0][0]=1;
		max=dp[0][0];
		for(int i=1,j=0;i<rows;i++){
			dp[i][j]=dp[i-1][j]+a[i][j];
		}
		for(int i=0,j=1;j<columns;j++){
			dp[i][j]=dp[i][j-1]+a[i][j];
		}
		for(int i=1;i<rows;i++){
			for(int j=1;j<columns;j++){
				dp[i][j]=a[i][j] + (dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1]);
			}
		}*/
		for(int i=0;i<rows;i++){
			for(int j=0;j<columns;j++){
				if(j>0 && i>0)
					dp[i][j]=a[i][j]+(dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1]);
				else if(j>0 && i==0)
					dp[i][j]=a[i][j]+(0>dp[i][j-1]?0:dp[i][j-1]);
				else if(j==0 && i>0)
					dp[i][j]=a[i][j]+(dp[i-1][j]>0?dp[i-1][j]:0);
				else
					dp[i][j]=a[i][j];
			}
		}
		return dp[rows-1][columns-1];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][]={};
		System.out.println(countMax(a));

	}

}
