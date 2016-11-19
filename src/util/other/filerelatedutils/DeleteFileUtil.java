package util.other.filerelatedutils;

import java.io.File;

public class DeleteFileUtil {
	public static void main(String[] args) {
		
		int arr[] = {1,3,4,8,10,11,13,15,16,18,22,23,24};
		for(int i: arr){
		String absolutePath1 = "/Users/ankurkumar/Desktop/TestCases/Ques_"+i+"/small/in";
		fun(absolutePath1);
		String absolutePath2 = "/Users/ankurkumar/Desktop/TestCases/Ques_"+i+"/small/out";
		fun(absolutePath2);
		}
		
	}
	public static void fun(String absolutePath){
		File dir = new File(absolutePath);
		File[] filesInDir = dir.listFiles();
		int i = 0;
		for (File file : filesInDir) {
			i++;
			String name = file.getName();
		
			if (name.contains("input4")) {
				System.out.println("file deleted");
				file.delete();
			} else if (name.contains("output4")) {
				file.delete();
				System.out.println("file deleted");
			}

		}
	}
}
