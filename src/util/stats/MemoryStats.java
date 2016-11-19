package util.stats;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MemoryStats {

	private long startMemory;
	private long endMemory;
	private long memoryUsage;

	public Map<String, String> memoryMap = new LinkedHashMap<>(10);
	public int count = 0;

	public void startMemoryUsage() {
		startMemory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
	}

	public void endMemoryUsage() {
		endMemory = (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
		memoryUsage = endMemory - startMemory;
		count++;
		saveMemoryUsage();
	}

	private void saveMemoryUsage() {
		memoryMap.put("TestCase_" + count, memoryUsage + "");
	}

	public void showMemoryUsageStamp(FileWriter writer) {
		try {
			System.out.println("               MEMORY STATS(in bytes):              ");
			writer.write("               MEMORY STATS(in bytes):              "+"\r\n");

			for (String key : memoryMap.keySet()) {
				System.out.println(key + "     :     " + memoryMap.get(key));
				writer.write(key + "     :     " + memoryMap.get(key)+"\r\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
