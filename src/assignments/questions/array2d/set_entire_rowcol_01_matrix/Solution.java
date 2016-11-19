package assignments.questions.array2d.set_entire_rowcol_01_matrix;
public class Solution {
	
	public static void makeRowsCols0(int [][]input) {
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[i].length; j++) {
				if(input[i][j] == 0) {
					input[i][j] = -1;
				}
			}
		}

		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[i].length; j++) {
				if(input[i][j] == -1) {
					for(int k = 0; k < input[i].length; k++) {
						if(input[i][k] != -1) {
							input[i][k] = 0;
						}
					}
					for(int k = 0; k < input.length; k++) {
						if(input[k][j] != -1) {
							input[k][j] = 0;
						}
					}
				}
			}
		}

		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[i].length; j++) {
				if(input[i][j] == -1) {
					input[i][j] = 0;
				}
			}
		}
	}
}