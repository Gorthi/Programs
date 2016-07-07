import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MajorityElement {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String num[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(num[i]);
		}
		int majElement = MajorityElement.findMajorityElement(arr);
		System.out.println(majElement);
	}

	private static int findMajorityElement(int[] arr) {
		int count = 0;
		int majElem = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == majElem) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				majElem = arr[i];
			}
		}
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (majElem == arr[i]) {
				count++;
			}
		}
		if (count > (arr.length / 2)) {
			return majElem;
		} else {
			return 0;
		}
	}

}
