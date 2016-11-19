package drivers.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import util.other.arrayutility.IntegerArrayUtility;

public class Parameter2DIntegerArrayCommand implements ParameterCommand {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int whatMattersArray;
	private  int indexLength = 0;
	private  int indexBredth = 0;
	private int length;
	private int bredth;
	private int min;
	private int max;
	private boolean isItSquareMatrix;
	List<Integer> arrayLengthlist;
	List<Integer> arrayBredthlist;

	@Override
	public void menu() {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter choice ");
		System.out.println("1: 2D Array ");

		whatMattersArray = s.nextInt();
		System.out.println("Is it Square Matrix ");
		isItSquareMatrix = s.nextBoolean();

		switch (whatMattersArray) {
		case 1:

			System.out.println("Array Length:");
			
			length = s.nextInt();
			System.out.println("Array Bredth:");
			
			bredth = s.nextInt();
			System.out.println("Min Element:");
			
			min = s.nextInt();
			System.out.println("Max Element:");
			max = s.nextInt();
			break;

		default:
			break;

		}
		arrayLengthlist = getArrayListLength(length,isItSquareMatrix);
		arrayBredthlist = getArrayListLength(bredth,isItSquareMatrix);
	}

	public ArrayList<Integer> getArrayListLength(int length, boolean squareMatrix) {
		ArrayList<Integer> list = ParameterCommandUtil.getArrayListLength(length);
		if(!isItSquareMatrix){
			Collections.shuffle(list.subList(3, list.size()-1));
		}
		return list;
	}

	public int[][] logic(int number) {
		int currentLength = arrayLengthlist.get(indexLength++);
		int currentBredth = arrayBredthlist.get(indexBredth++);
		switch (number) {
		case 1:
			int arr[][] = new int[currentLength][];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = IntegerArrayUtility.randomArrayGenerator(currentBredth, min, max);
			}
			return arr;
		default:
			return null;
		}

	}

	/**
	 * 2D Array Incomplete
	 */
	@Override
	public void execute(ArrayList<String> result) {
		
		int arr[][] = logic(whatMattersArray);
		StringBuilder str = new StringBuilder();
		str.append(arrayLengthlist.get(indexLength-1) + " ");
		str.append(arrayBredthlist.get(indexBredth-1) + " ");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				str = str.append(arr[i][j] + " ");
			}

		}
		result.add(str.toString());
	}


	@Override
	public int[][] read(String line) {
		String[] valueStr = new String(line).trim().split(" ");
		int indx = 0;
		int length = Integer.parseInt(valueStr[indx++]);
		int bredth = Integer.parseInt(valueStr[indx++]);
		int[][] inputArrayParameter = new int[length][bredth];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < bredth; j++) {
				inputArrayParameter[i][j] = Integer.parseInt(valueStr[indx++]);
			}
		}

		return inputArrayParameter;
	}

}
