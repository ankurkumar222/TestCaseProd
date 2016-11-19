package drivers.commands;

import java.io.Serializable;
import java.util.ArrayList;

public interface ParameterCommand extends  Serializable{
	
	public void menu();
	public void execute(ArrayList<String> result);
	public Object read(String line);
	public String toString();
}
