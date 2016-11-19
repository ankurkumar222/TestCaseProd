package util.stats;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class TimeStats {

	private long startTime;
	private long endTime;
	private long timeUse;

	public Map<String, String> timeMap = new LinkedHashMap<>(10);
	public int count = 0;

	public void startTimeUsage() {
		startTime = System.currentTimeMillis();
	}

	public void endTimeUsage() {
		endTime = System.currentTimeMillis();
		timeUse = endTime - startTime;
		count++;
		saveTimeUsage();
	}

	private void saveTimeUsage() {
		timeMap.put("TestCase_" + count, timeUse + "");
	}

	public void showTimeUsageStamp(FileWriter writer) {
		System.out.println("               TIME STATS(in ms):              ");
		try {
			writer.write("               TIME STATS(in bytes):              "+"\r\n");
			

			for (String key : timeMap.keySet()) {
				System.out.println(key + "     :     " + timeMap.get(key));
				writer.write(key + "     :     " + timeMap.get(key)+"\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
