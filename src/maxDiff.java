import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *find max difference between 2 elements such that the larger element appears after the smaller one.
 *
 *find the diff between 2 successive elements and store it in an array. then fing=d the max sum sub array. 
 *you need not store it in an array... you can process it simultaneously.
 */

public class maxDiff {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String num[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(num[i]);
		}
		int ans = findDiff(arr);
		System.out.println(ans);
	}

	private static int findDiff(int[] arr) {
		int length = arr.length;
		if (length == 1)
			return arr[0];
		int diff = arr[1] - arr[0];
		int currDiff = diff;
		int maxDiff = currDiff;
		for (int i = 1; i < length-1; i++) {
			diff = arr[i + 1] - arr[i];
			if (currDiff > 0){
				currDiff += diff;
			} else{
				currDiff = diff;
			}
			if (maxDiff < currDiff)
				maxDiff = currDiff;
		}
		return maxDiff;
	}

}
