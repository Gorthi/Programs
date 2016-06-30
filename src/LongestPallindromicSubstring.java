import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestPallindromicSubstring {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		findSubstring(input);
	}

	private static void findSubstring(String input) {
		int length = input.length();
		int max = 0;
		int start = 0;
		int dp[][] = new int[length][length];
		for (int i = 0; i < length; i++) {
			dp[i][i] = 1;
		}
		for (int i = 0; i < length-1; i++) {
			if (input.charAt(i) == input.charAt(i + 1)) {
				dp[i][i+1] = 1;
			}
			max = 2;
			start = i;
		}
		for (int k = 3; k < length; k++) {
			for (int i = 0; i < length - k + 1; i++) {
				int j = i + k - 1;
				if (dp[i + 1][j - 1] == 1 && input.charAt(i) == input.charAt(j)) {
					dp[i][j] = 1;
					if (k > max) {
						max = k;
						start = i;
					}
				}

			}
		}
		printSubstring(input, start, max + start-1);

	}

	private static void printSubstring(String input, int start, int i) {
		String sub = input.substring(start, i + 1);
		System.out.println(sub);
	}

}
