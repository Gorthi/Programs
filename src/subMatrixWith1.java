/*
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
 */
public class subMatrixWith1 {

	public static void main(String[] args) {
		int M[][] = new int[][] { { 1, 1, 0, 0 },

				{ 1, 1, 1, 0 },

				{ 0, 1, 1, 0 },

				{ 0, 0, 0, 0 } };

		printMaxSubSquare(M);

	}

	private static void printMaxSubSquare(int[][] m) {
		int row = m.length;
		int col = m[0].length;
		int aux[][] = new int[row][col];
		int max = 0;
		int start = 0, end = 0;
		for (int i = 1; i < col; i++) {
			aux[0][i] = m[0][i];
		}
		for (int i = 0; i < row; i++) {
			aux[i][0] = m[i][0];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (m[i][j] == 0) {
					aux[i][j] = 0;
				} else {
					aux[i][j] = Math.min(aux[i - 1][j], Math.min(aux[i - 1][j - 1], aux[i][j - 1])) + 1;
					if (aux[i][j] > max) {
						max = aux[i][j];
						start = i;
						end = j;
					}
				}
			}
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(aux[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println();
		
		for (int i = start; i > start - max; i--) {
			for (int j = end; j > end - max; j--) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}

	}

}
