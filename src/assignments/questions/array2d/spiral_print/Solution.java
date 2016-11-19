package assignments.questions.array2d.spiral_print;

public class Solution {
	public static StringBuilder result = new StringBuilder("");

	public static void spiralPrint(int matrix[][]) {
		int row = matrix.length;
		int col = matrix[0].length;

		int i, rowStart = 0, colStart = 0;

		int numElements = row * col, count = 0;

		while (count < numElements) {
			for (i = colStart; count < numElements && i < col; ++i) {
				//System.out.print(matrix[rowStart][i] + " ");
				result.append(matrix[rowStart][i] + " ");
				count++;
			}
			rowStart++;

			for (i = rowStart; count < numElements && i < row; ++i) {
				//System.out.print(matrix[i][col - 1] + " ");
				result.append(matrix[i][col - 1] + " ");
				count++;
			}
			col--;

			for (i = col - 1; count < numElements && i >= colStart; --i) {
				//System.out.print(matrix[row - 1][i] + " ");
				result.append(matrix[row - 1][i] + " ");
				count++;
			}
			row--;

			for (i = row - 1; count < numElements && i >= rowStart; --i) {
				//System.out.print(matrix[i][colStart] + " ");
				result.append(matrix[i][colStart] + " ");
				count++;
			}
			colStart++;
		}
	}
}