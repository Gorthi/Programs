import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given an array of length n. Divide the array between two subarrays such that diff between sum 
 * of each subarray should be minimum. for even n: subarray lengths should b n/2 exact for odd n: subarray lengths should be (n-1)/2 
 * and (n+1)/2 e.g. given array 5,6,11,13,14,25 two subarrays: {5,6,25} and {11,13,14} diff between sums = 2 so output 2.
 */
public class MinimumDiffSubArray {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String num[] = br.readLine().split(",");
		int a[] = new int[n];
		int totalSum = 0;
		for(int i=0;i<n;i++){
			a[i] = Integer.parseInt(num[i]);
			totalSum += a[i];
		}
		int absoluteDifference = AbsDiff(a,0,totalSum,0,0);
		System.out.println(absoluteDifference);
	}

	private static int AbsDiff(int[] a,int sum,int totalSum,int size,int i) {
		int length = a.length;
		//System.out.println(i);
		if(length%2==0){
			if(size==length/2 || i==length){
				System.out.println("size of the subarray is:"+size);
				return Math.abs(totalSum-sum - sum);
			}
				
			return Math.min(AbsDiff(a,sum+a[i],totalSum,size++,i+1), AbsDiff(a,sum,totalSum,size,i+1));
		} else{
			if(size==(length-1)/2 || size==(length+1)/2 || i==length){
				System.out.println("size of the subarray is:"+size);
				return Math.abs(totalSum-sum - sum);
			}
			return Math.min(AbsDiff(a,sum+a[i],totalSum,size++,i+1), AbsDiff(a,sum,totalSum,size,i+1));
		}
		//return 0;
	}

}
