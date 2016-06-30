import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxProfit {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String num[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(num[i]);
		}
		findMaxProfit(arr);
	}

	private static void findMaxProfit(int[] price) {
		int profit[] = new int[price.length];
		int maxPrice = price[price.length - 1];
		for (int i = price.length - 2; i > 0; i--) {
			if (maxPrice < price[i])
				maxPrice = price[i];
			profit[i] = Math.max(maxPrice - price[i], profit[i + 1]);
		}
		int minPrice = price[0];
		for (int i = 1; i < price.length; i++) {
			if (price[i] < minPrice) {
				minPrice = price[i];
			}
			profit[i] = Math.max((profit[i] + (price[i] - minPrice)), profit[i - 1]);
		}
		System.out.println(profit[price.length - 1]);
	}

}
