import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Subsequence {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t>0){
			//int n = Integer.parseInt(br.readLine());
			String s = br.readLine();
			int ans = findSubsequence(s);
			System.out.println(ans);
			t--;
		}
	}

	private static int findSubsequence(String s) {
		int length = s.length();
		int[] dp = new int[length+1];
		int last[] = new int[256];
		dp[0] = 1;
		for(int i=1;i<=length;i++){
			dp[i] = dp[i-1] * 2;
			//System.out.println(dp[i]);
			if(last[s.charAt(i-1)] != 0){
				dp[i] = dp[i] - dp[last[s.charAt(i-1)]-1];
			}
			last[s.charAt(i-1)] = i;
		}
		return dp[length];
	}

}
