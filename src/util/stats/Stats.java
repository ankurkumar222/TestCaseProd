package util.stats;

import static constants.TestCaseConstants.STAT_FILE;
import static constants.TestCaseConstants.TESTCASE_FOLDER_PATH;
import static drivers.TestCaseParser.quesName;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Stats {

	private static Stats stats = new Stats();
	MemoryStats memoryStats;
	TimeStats timeStats;

	private Stats() {
		memoryStats = new MemoryStats();
		timeStats = new TimeStats();
	}

	public static Stats getStatsInstance() {
		return stats;
	}

	public void startStat() {
		memoryStats.startMemoryUsage();
		timeStats.startTimeUsage();
	}

	public void endStat() {
		memoryStats.endMemoryUsage();
		timeStats.endTimeUsage();
	}

	public void showStats() {
		String filePath = TESTCASE_FOLDER_PATH + quesName + STAT_FILE;
		File inputFile = new File(filePath);
		FileWriter writer = null;
		try {
			writer = new FileWriter(inputFile);
			inputFile.getParentFile().mkdirs();
			inputFile.createNewFile();
			memoryStats.showMemoryUsageStamp(writer);
			System.out.println();
			timeStats.showTimeUsageStamp(writer);
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
