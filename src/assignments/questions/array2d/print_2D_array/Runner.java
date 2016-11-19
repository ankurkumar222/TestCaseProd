package assignments.questions.array2d.print_2D_array;

import assignments.commonutils.ArrayUtility;
import util.stats.Stats;

public class Runner {

	public static void test(int[][] arr, String filePath) {
		Solution.result = new StringBuilder("");
		Stats stats = Stats.getStatsInstance();
		stats.startStat();
		Solution.print2DArray(arr);
		stats.endStat();
		ArrayUtility.print(Solution.result + "", filePath);
	}
}