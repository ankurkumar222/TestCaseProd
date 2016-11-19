package util.logs.writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {

	File file;
	static FileWriter fileWriter;
	static BufferedWriter bufferWriter;

	public LogWriter(String fileName) {

		file = new File(fileName);

		// creates the file
		try {
			file.getParentFile().mkdirs();
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fileWriter = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writing(String whatToWrite) {
		if (whatToWrite == null || whatToWrite.isEmpty()) {
			return;
		}
		try {
			fileWriter.write(whatToWrite);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

	}
}