package assignments.questions.array2d.set_entire_rowcol_01_matrix;
import assignments.commonutils.ArrayUtility;
import util.stats.Stats;

public class Runner {
	public static void test(int[][] arr, String filePath) {
		Stats stats = Stats.getStatsInstance();
		stats.startStat();
		Solution.makeRowsCols0(arr);
		stats.endStat();
		ArrayUtility.print2DArray(arr,filePath);
	}
}
