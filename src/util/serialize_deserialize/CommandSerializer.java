package util.serialize_deserialize;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import constants.TestCaseConstants;
import drivers.TestCaseGenerator;
import drivers.commands.ParameterCommand;

public class CommandSerializer {
	public static void serializeParameterList(List<ParameterCommand> parameterList) throws IOException {
		File file = new File(TestCaseConstants.TESTCASE_FOLDER_PATH+TestCaseGenerator.quesName+"serialized.xml");
		file.createNewFile();
		FileOutputStream os = new FileOutputStream(file);
		XMLEncoder encoder = new XMLEncoder(os);
		encoder.writeObject(parameterList);
		encoder.close();
	}
}
