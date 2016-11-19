package drivers.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import util.other.arrayutility.IntegerArrayUtility;

public class ParameterIntegerArrayCommand implements ParameterCommand {

	private static final long serialVersionUID = 1L;
	private static int whatMattersArray;
	private int length;
	private int min;
	private int max;
	private int diff;
	List<Integer> arrayLengthlist = new ArrayList<Integer>(9);
	List<Integer> rotateIndexList = new ArrayList<Integer>(9);

	@Override
	public void menu() {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter choice ");
		System.out.println("1: Random Array");
		System.out.println("2: Sorted Increasing Array");
		System.out.println("3: Sorted Increasing Array (duplicates)");
		System.out.println("4: Sorted Decreasing Array");
		System.out.println("5: Sorted Decreasing Array (duplicates)");
		System.out.println("6. Rotated Increasing Array");
		System.out.println("7. Rotated Decreasing Array");
		System.out.println("8. Consecutive Unsorted Array");

		whatMattersArray = s.nextInt();
		System.out.println("Array Length:");
		length = s.nextInt();

		switch (whatMattersArray) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("Array Min Element");
			min = s.nextInt();
			System.out.println("Array Max Element");
			max = s.nextInt();
			break;
		case 6:
		case 7:
			System.out.println("Array Min Element");
			min = s.nextInt();
			System.out.println("Array Max Element");
			max = s.nextInt();
			rotateIndexList = ParameterCommandUtil.getArrayListLength(length);
			break;
		case 8:
			System.out.println("Array Min Element");
			min = s.nextInt();
			System.out.println("Diff value");
			diff = s.nextInt();
			break;

		}

		arrayLengthlist = ParameterCommandUtil.getArrayListLength(length);
		// s.close();
	}

	public int[] logic(int number) {
		int currentLength = arrayLengthlist.remove(0);
		switch (number) {

		case 1:
			return IntegerArrayUtility.randomArrayGenerator(currentLength, min, max);
		case 2:
			return IntegerArrayUtility.increasingIntegerArray(currentLength, min, max);
		case 3:
			return IntegerArrayUtility.increasingIntegerArrayWithDuplicates(currentLength, min, max);
		case 4:
			return IntegerArrayUtility.decreasingIntegerArray(currentLength, min, max);
		case 5:
			return IntegerArrayUtility.decreasingIntegerArrayWithDuplicates(currentLength, min, max);
		case 6:
			int rotateBy1 = rotateIndexList.remove(0);
			System.out.println("Rotate By:  " + rotateBy1 / 2);
			return IntegerArrayUtility.rotatedIncreasingArray(currentLength, rotateBy1 / 2, min, max);
		case 7:
			int rotateBy2 = rotateIndexList.remove(0);
			System.out.println("Rotate By:  " + rotateBy2 / 2);
			return IntegerArrayUtility.rotatedDecreasingArray(currentLength, rotateBy2 / 2, min, max);
		case 8:
			return IntegerArrayUtility.getConsecutiveUnsortedArray(currentLength, min, diff);
		default:
			return null;
		}
	}

	@Override
	public void execute(ArrayList<String> result) {
		StringBuilder str = new StringBuilder();
		int arr[] = logic(whatMattersArray);
		str.append(arr.length + " ");
		for (int j = 0; j < arr.length; j++) {
			str.append(arr[j] + " ");
		}
		result.add(str.toString());
	}

	@Override
	public int[] read(String line) {
		String[] valueStr = new String(line).trim().split(" ");
		int[] inputArrayParameter = new int[valueStr.length - 1];
		int arrLength = Integer.parseInt(valueStr[0].trim());
		for (int i = 0; i < arrLength; i++) {
			if (!valueStr[i + 1].isEmpty()) {
				inputArrayParameter[i] = Integer.parseInt(valueStr[i + 1].trim());
			}
		}
		return inputArrayParameter;
	}
}
