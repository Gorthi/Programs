import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Count number of binary strings without consecutive ones
 * input : 2
 * output : 3
 * 00 01 10
 */
public class BinaryStrings {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(countString(n));
	}

	private static int countString(int n) {
		int a[] = new int[n]; //ending in 0
		int b[] = new int[n]; //ending in 1
		a[0] = 1;
		b[0] = 1;
		for(int i=1;i<n;i++){
			a[i] = a[i-1] + b[i-1];
			b[i] = a[i-1];
		}
		return a[n-1]+b[n-1];
	}

}
