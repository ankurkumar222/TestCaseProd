package drivers.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.other.stringutil.StringUtil;

public class ParameterStringCommand implements ParameterCommand {

	private static final long serialVersionUID = 1L;
	List<Integer> stringLengthlist;
	List<Integer> stringWordlist;
	int StringType;
	int textLength;
	int numberOfWords;

	@Override
	public void menu() {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter choice ");
		System.out.println("1: String['a' to 'z']");
		System.out.println("2: String['A' to 'Z']");
		System.out.println("3: String['1' to '9']");
		System.out.println("4: String[alphanumeric]");
		System.out.println("5: String line");
		System.out.println("7: String & Its Permutation");

		StringType = s.nextInt();

		switch (StringType) {
		case 1:
		case 2:
		case 3:
		case 4:
			System.out.println("Text Length:");
			textLength = s.nextInt();
			stringLengthlist = ParameterCommandUtil.getArrayListLength(textLength);
			break;
		case 5:
			System.out.println("Number of Words:");
			numberOfWords = s.nextInt();
			stringLengthlist = ParameterCommandUtil.getArrayListLength(numberOfWords);
			break;

		case 7:
			break;
		default:
			break;
		}

		
	}



	public String logic(int number) {
		int currentLength = stringLengthlist.remove(0);
		switch (number) {
		case 1:
			return StringUtil.getRequiredString(currentLength, StringUtil.StringType.SMALL);
		case 2:
			return StringUtil.getRequiredString(currentLength, StringUtil.StringType.CAPITAL);
		case 3:
			return StringUtil.getRequiredString(currentLength, StringUtil.StringType.NUMERIC);
		case 4:
			return StringUtil.getRequiredString(currentLength, StringUtil.StringType.ALPHANUMERIC);
		case 5:
			return StringUtil.generateUniqueStringOfGivenLength(currentLength);
		case 7:
			String inputTemp = StringUtil.getRequiredString(currentLength, StringUtil.StringType.SMALL);
			return StringUtil.generatePermutationOfString(inputTemp);
		default:

			return null;
		}
	}

	@Override
	public void execute(ArrayList<String> result) {
		String ans = logic(StringType);
		result.add(ans);
	}

	@Override
	public String read(String line) {
		return line;
	}

}
