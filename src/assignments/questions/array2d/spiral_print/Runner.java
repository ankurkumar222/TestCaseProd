package assignments.questions.array2d.spiral_print;

import assignments.commonutils.ArrayUtility;

import util.stats.Stats;

public class Runner {
	public static void test(int[][] arr, String filePath) {
		Solution.result = new StringBuilder("");
		Stats stats = Stats.getStatsInstance();
		stats.startStat();
		Solution.spiralPrint(arr);
		stats.endStat();
		ArrayUtility.print(Solution.result.toString(),filePath);
	}
}
