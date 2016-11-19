package util.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
	private String SOURCE_FOLDER = "";
	List<String> fileList;

	public Zip() {
		fileList = new ArrayList<String>();
	}

	

	/**
	 * Zip it
	 * 
	 * @param zipFile
	 *            output ZIP file location
	 */
	public void zipIt(String zipFile, String sourceFolder) {
		
		this.SOURCE_FOLDER = sourceFolder;
		generateFileList(new File(SOURCE_FOLDER));
		byte[] buffer = new byte[1024];

		try {

			FileOutputStream fos = new FileOutputStream(zipFile);
			ZipOutputStream zos = new ZipOutputStream(fos);

			System.out.println("Output : " + zipFile);

			for (String file : this.fileList) {
				// bug fix
				if (file.contains("DS_Store")) {
					continue;
				}
				// System.out.println("File Added : " + file);
				ZipEntry ze = new ZipEntry(file);
				zos.putNextEntry(ze);

				FileInputStream in = new FileInputStream(SOURCE_FOLDER + File.separator + file);

				int len;
				while ((len = in.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}

				in.close();
			}

			zos.flush(); //lets check this Ankur changes
			zos.closeEntry();
			// remember close it
			zos.close();

			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Traverse a directory and get all files, and add the file into fileList
	 * 
	 * @param node
	 *            file or directory
	 */
	private void generateFileList(File node) {

		// add file only
		if (node.isFile()) {
			fileList.add(generateZipEntry(node.getAbsoluteFile().toString()));
		}

		if (node.isDirectory()) {
			String[] subNote = node.list();
			for (String filename : subNote) {
				generateFileList(new File(node, filename));
			}
		}

	}

	/**
	 * Format the file path for zip
	 * 
	 * @param file
	 *            file path
	 * @return Formatted file path
	 */
	private String generateZipEntry(String file) {
		return file.substring(SOURCE_FOLDER.length(), file.length());
	}
}
