package assignments.questions;


public class Solution {
	public static StringBuilder result = new StringBuilder("");
	public static void print2DArray(int input[][]) {
		int k = input.length;
		for(int i = 0; i < input.length; i++) {
			for(int l = k-1; l >= 0; l--) {
				for(int j = 0; j < input[i].length; j++) {
					//System.out.print(input[i][j] + " ");
					result.append(input[i][j] + " ");
				}
				//System.out.println();
				result.append("\r\n");
			}
			k--;
		}
	}

}