import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Sort a string based on a given string
 * input : abcdefgggggg  fegabdc
 * output : feggggggabdc 
 */
public class SortBasedOnString {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String toBeSorted = br.readLine();
		String order = br.readLine();
		sortString(toBeSorted,order);
	}

	/*private static void sortString(String toBeSorted, String order) {
		int countArray[] = new int[26];
		for(int i = 0; i<toBeSorted.length();i++){
			countArray[toBeSorted.charAt(i)-'a']++;
		}
		for(int i=0;i<order.length();i++){
			while(countArray[order.charAt(i)-'a']>0){
				System.out.print(order.charAt(i));
				countArray[order.charAt(i)-'a']--;
			}
		}
		System.out.println();
	}*/
	private static void sortString(String toBeSorted, String order) {
		int countArray[] = new int[256];
		for(int i = 0; i<toBeSorted.length();i++){
			countArray[toBeSorted.charAt(i)]++;
		}
		for(int i=0;i<order.length();i++){
			while(countArray[order.charAt(i)]>0){
				System.out.print(order.charAt(i));
				countArray[order.charAt(i)]--;
			}
		}
		System.out.println();
	}
}
