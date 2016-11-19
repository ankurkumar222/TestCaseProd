package util.other.filerelatedutils;

import java.io.File;

public class Util2 {
	public static void main(String[] args) {

		int arr[] = { 1, 3, 4, 8, 10, 11, 13, 15, 16, 18, 22, 23, 24 };
		for (int i : arr) {
			String absolutePath1 = "/Users/ankurkumar/Desktop/TestCases/Ques_" + i + "/small/in";
			fun(absolutePath1);
			String absolutePath2 = "/Users/ankurkumar/Desktop/TestCases/Ques_" + i + "/small/out";
			fun(absolutePath2);
		}

	}

	public static void fun(String absolutePath) {
		File dir = new File(absolutePath);
		File[] filesInDir = dir.listFiles();
		int i = 0;
		for (File file : filesInDir) {
			i++;
			String name = file.getName();
			String newName = null;
			String newPath = null;
			if (name.contains("input5")) {

				newName = name.replace("input5", "input6");
				newPath = absolutePath + "/" + newName;
				file.renameTo(new File(newPath));
				System.out.println(name + "  TO  " + newName);
			} else if (name.contains("output65")) {
				newName = name.replace("output65", "output6");
				newPath = absolutePath + "/" + newName;
				file.renameTo(new File(newPath));
				System.out.println(name + "  TO  " + newName);
			}
			

		}
	}
}
