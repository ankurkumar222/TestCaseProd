package util.other.filerelatedutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MoveFileUtil {
	public static void main(String[] args) throws IOException {
		// "ContainsX",
		String arr2[] = { "ContainsX","isIdentical", "maxSumNode", "nextLargerElement", "NodesGreaterThanX", "numLeafNodes", "replaceWithDepthValue", "secondLargest"};
		for (String i : arr2) {
			int arr1[] = { 1,2,3,4,5,6};
			for(int k:arr1){
				String src="/Users/ankurkumar/Downloads/GenricTrees/"+i+"/in/input"+k+ ".txt";
				String dest="/Users/ankurkumar/Downloads/GenricTrees/" + i + "/large/in/input"+(k)+".txt";
				moveToLoc(src, dest);
			}
		}
	}
///Users/ankurkumar/Downloads/GenricTrees/isIdentical/in
	public static void moveToLoc(String source, String dest) throws IOException {
		File f = new File(dest);

		f.getParentFile().mkdirs(); 
		f.createNewFile();
		InputStream inStream = null;
		OutputStream outStream = null;

		try {

			File afile = new File(source);
			File bfile = new File(dest);

			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}

			inStream.close();
			outStream.close();

			// delete the original file
			afile.delete();

			System.out.println("File is copied successful!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}