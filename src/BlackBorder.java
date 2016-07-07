import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BlackBorder {

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int row = Integer.parseInt(br.readLine());
		int col = Integer.parseInt(br.readLine());
		int array[][] = new int[row][col];
		for (int i = 0; i < row; i++) {
			String num[] = br.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				array[i][j] = Integer.parseInt(num[j]);
			}
		}

	}

}
