import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PallindromeSubsequence {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int ans = findSubsequence(input);
		System.out.println(ans);
	}

	private static int findSubsequence(String input) {
		int length = input.length();
		int dp[][] = new int[length][length];
		for (int i = 0; i < length; i++) {
			dp[i][i] = 1;
		}
		for (int sl = 2; sl <= length; sl++) {
			for (int i = 0; i < length - sl + 1; i++) {
				int j = i + sl - 1;
				if (input.charAt(i) == input.charAt(j) && sl == 2) {
					dp[i][j] = 2;
				}
				if (input.charAt(i) == input.charAt(j)) {
					dp[i][j] = dp[i+1][j-1] + 2;
				} else{
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}

		}
		return dp[0][length - 1];

	}
}
