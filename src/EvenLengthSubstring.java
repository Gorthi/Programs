import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Longest Even Length Substring such that Sum of First and Second Half is same
 */
public class EvenLengthSubstring {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int ans = findLength(input);
		System.out.println(ans);
	}

	private static int findLength(String input) {
		int maxLength = 0;
		for(int i=0;i<=input.length()-2;i++){
			int left = i;
			int right = left + 1;
			int leftSum = 0, rightSum = 0;
			while(right<input.length() && left >=0){
				leftSum += (int)input.charAt(left);
				rightSum += (int)input.charAt(right);
				if(leftSum == rightSum){
					maxLength = Math.max(maxLength, right-left+1);
				}
				left--;
				right++;
			}
		}
		
		return maxLength;
	}

}
