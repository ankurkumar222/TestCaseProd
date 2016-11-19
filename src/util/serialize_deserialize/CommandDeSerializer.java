package util.serialize_deserialize;

import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import drivers.commands.ParameterCommand;

public class CommandDeSerializer {
	@SuppressWarnings("unchecked")
	public static ArrayList<ParameterCommand> deserializeParameterList(String fileName) throws FileNotFoundException {
		FileInputStream is = new FileInputStream(fileName);
		XMLDecoder decoder = new XMLDecoder(is);
		Object object = (Object) decoder.readObject();
		decoder.close();
		return (ArrayList<ParameterCommand>) object;
	}
}
