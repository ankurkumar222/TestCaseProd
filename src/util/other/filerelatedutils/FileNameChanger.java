package util.other.filerelatedutils;

import java.io.File;

public class FileNameChanger {
	public static void main(String[] args) {
		// change file names in 'Directory':
		String absolutePath1 = "/Users/ankurkumar/Desktop/TestCases/Ques_24/small/in";
		fun(absolutePath1);
		String absolutePath2 = "/Users/ankurkumar/Desktop/TestCases/Ques_24/small/out";
		fun(absolutePath2);
		String absolutePath3 = "/Users/ankurkumar/Desktop/TestCases/Ques_24/large/in";
		fun(absolutePath3);
		String absolutePath4 = "/Users/ankurkumar/Desktop/TestCases/Ques_24/large/out";
		fun(absolutePath4);
	}
	
	public static void fun(String absolutePath){
		File dir = new File(absolutePath);
		File[] filesInDir = dir.listFiles();
		int i = 0;
		for (File file : filesInDir) {
			i++;
			String name = file.getName();
			String newName = null;
			String newPath = null;
			if (name.contains("in")) {
				newName = name.replace("in", "input");
				newPath = absolutePath + "/" + newName;
				file.renameTo(new File(newPath));
			} else if (name.contains("out")) {
				newName = name.replace("out", "output");
				newPath = absolutePath + "/" + newName;
				file.renameTo(new File(newPath));
			}

			System.out.println(name + " changed to " + newName);
		}
	}
}
