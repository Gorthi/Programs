import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PallindromicSentence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(checkPallindrome(input));
	}

	private static boolean checkPallindrome(String input) {
		boolean isP = true;
		for(int i=0,j=input.length()-1;i<j;i++,j--){
			if(input.charAt(i)!=input.charAt(j)){
				isP = false;
				break;
			}
		}
		return isP;

	}

}
