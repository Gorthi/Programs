import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 
 * (or true) then make all the cells of ith row and jth column as 1.
 */
public class BooleanMatrix {
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
		convertMatrix(array);
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void convertMatrix(int[][] array) {
		int rowFlag = 0, colFlag = 0;
		for (int i = 0; i < array[0].length; i++) {
			if (array[0][i] == 1)
				rowFlag = 1;
		}
		for (int i = 0; i < array.length; i++) {
			if (array[i][0] == 1)
				colFlag = 1;
		}
		for(int i=0;i<array.length;i++){
			for(int j=0;j<array[0].length;j++){
				if(array[i][j]==1){
					array[0][j] = 1;
					array[i][0] = 1;
				}
			}
		}
		for(int i=1;i<array.length;i++){
			for(int j=1;j<array[0].length;j++){
				if(array[0][j]==1 || array[i][0]==1){
					array[i][j] =1;
				}
			}
		}
		if(rowFlag==1){
			for(int i=0;i<array[0].length;i++)
				array[0][i]=1;
		}
		if(colFlag==1){
			for(int i=0;i<array.length;i++)
				array[i][0]=1;
		}
	}
}
