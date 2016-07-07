import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicates {

	public static void main(String[] args) throws IOException{
		RemoveDuplicates rd = new RemoveDuplicates();
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		rd.removeDup(input);
	}

	private void removeDup(String input) {
		StringBuffer in = new StringBuffer(input);
		int resultIndex=0;
		int countArray[] = new int[256];
		for(int i=0;i<in.length();i++){
			if(countArray[in.charAt(i)]==0){
				countArray[in.charAt(i)]++;
				in.insert(resultIndex, in.charAt(i));
				resultIndex++;
			}
		}
		input = in.substring(0, resultIndex);
		System.out.println(input);
	}

}
