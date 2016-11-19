package drivers;

import java.util.ArrayList;
import java.util.List;

import constants.TestCaseConstants;
import drivers.commands.ParameterCommand;

public class TestCaseController {
	private static TestCaseController instance = null;
	private static Object mutex = new Object();

	private TestCaseController() {

	}

	public static TestCaseController getInstance() {
		if (instance == null) {
			synchronized (mutex) {
				if (instance == null)
					instance = new TestCaseController();
			}
		}
		return instance;
	}

	public static List<ParameterCommand> parameterList = new ArrayList<ParameterCommand>();

	public void putParameter(ParameterCommand parameter) {
		parameterList.add(parameter);
	}

	public ArrayList<ArrayList<ArrayList<String>>> generateParameters() {
		ArrayList<ArrayList<ArrayList<String>>> finalResult = new ArrayList<ArrayList<ArrayList<String>>>();
		for (int no_of_testCases = 0; no_of_testCases < TestCaseConstants.EXACT_TEST_CASE; no_of_testCases++) {

			ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
			for (int i = 0; i < parameterList.size(); i++) {

				ArrayList<String> list = new ArrayList<String>();
				parameterList.get(i).execute(list);
				result.add(list);
				
			}
			System.out.println("      TestCase: "+ no_of_testCases +" successs");
			finalResult.add(result);

		}

		return finalResult;
	}

}
