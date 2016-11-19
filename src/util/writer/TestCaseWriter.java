package util.writer;

import static constants.TestCaseConstants.EXT;
import static constants.TestCaseConstants.LARGE_INPUT_FILE;
import static constants.TestCaseConstants.SMALL_INPUT_FILE;
import static constants.TestCaseConstants.TESTCASE_FOLDER_PATH;
import static drivers.TestCaseGenerator.quesName;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;;

public class TestCaseWriter {

	public static void write(ArrayList<ArrayList<ArrayList<String>>> testcases) throws IOException {
		String smallInputFilePath = TESTCASE_FOLDER_PATH + quesName + SMALL_INPUT_FILE + EXT;

		
		File smallTestCasesInputFile = getNewInputFile(smallInputFilePath);
		FileWriter smallWriter = new FileWriter(smallTestCasesInputFile);
		smallWriter.write("           SMALL INPUT FILE            ");
		
		smallWriter.write(System.lineSeparator());
		smallWriter.write(System.lineSeparator());
		for (int i = 1; i <=3; i++) {
			writeToFile(smallWriter, testcases.get(i-1), i);
		}
		smallWriter.flush();
		smallWriter.close();
		System.out.println("SMALL INPUT files successfully created ....  ");
		String largeInputFilePath = TESTCASE_FOLDER_PATH + quesName + LARGE_INPUT_FILE + EXT;
		File largeTestCasesInputFile = getNewInputFile(largeInputFilePath);
		FileWriter largeWriter = new FileWriter(largeTestCasesInputFile);
		largeWriter.write("        LARGE INPUT FILE          ");
		
		largeWriter.write(System.lineSeparator());
		largeWriter.write(System.lineSeparator());
		for (int i = 4; i <= testcases.size(); i++) {
			writeToFile(largeWriter, testcases.get(i-1), i-3 );
		}
		largeWriter.flush();
		largeWriter.close();
		System.out.println("LARGE INPUT files successfully created ....  ");
		openFileToEdit(smallTestCasesInputFile);
		openFileToEdit(largeTestCasesInputFile);
		System.out.println("File Loc: "+ smallTestCasesInputFile);
	}

	public static void openFileToEdit(File file) {
		if (!Desktop.isDesktopSupported()) {
			System.out.println("Desktop is not supported");
			return;
		}
		Desktop desktop = Desktop.getDesktop();
		if (file.exists()) {
			try {
				desktop.open(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void writeToFile(FileWriter writer, ArrayList<ArrayList<String>> currentTestCase,
			int currentTestCaseNumber) {
		try {
			writer.write("----------------   TestCase: " + currentTestCaseNumber + "   ----------------");

			for (ArrayList<String> y : currentTestCase) {
				for (String z : y) {
					writer.write(System.lineSeparator());
					writer.write(z);
				}
			}
			
			writer.write(System.lineSeparator());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static File getNewInputFile(String filePath) {
		File inputFile = new File(filePath);
		File parentFolder = inputFile.getParentFile();
		if (parentFolder.exists()) {
			if (parentFolder.isDirectory()) {
				String[] entries = parentFolder.list();
				for (String s : entries) {
					File currentFile = new File(parentFolder.getPath(), s);
					currentFile.delete();
				}
			}
		}
		inputFile.getParentFile().mkdirs();
		try {
			inputFile.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputFile;

	}
}
