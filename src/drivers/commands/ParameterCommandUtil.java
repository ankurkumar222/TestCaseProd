package drivers.commands;

import java.util.ArrayList;
import java.util.Arrays;

public class ParameterCommandUtil {
	public static ArrayList<Integer> getArrayListLength(int length) {
		int digitLength = (int) (Math.log10(length));
		switch (digitLength) {
		case 0:
			int count = 0;
			ArrayList<Integer> list = new ArrayList<>();
			while (count <= length) {
				list.add(count);
				count++;
			}
			while (count <= 9) {
				list.add(length);
				count++;
			}
			return list;
		case 1:
			return new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, length));
		case 2:
			return new ArrayList<Integer>(Arrays.asList(1, 10, 30, 40, 50, 60, 70, 80, length));
		case 3:
			return new ArrayList<Integer>(Arrays.asList(1, 10, 20, 50, 75, 100, 250, 500, length));
		case 4:
			return new ArrayList<Integer>(Arrays.asList(1, 10, 20, 50, 100, 500, 1000, 5000, length));
		case 5:
			return new ArrayList<Integer>(Arrays.asList(1, 10, 20, 50, 75, 100, 1000, 10000, length));
		case 6:
			return new ArrayList<Integer>(Arrays.asList(1, 20, 50, 75, 100, 1000, 10000, 100000, length));
		case 7:
			return new ArrayList<Integer>(Arrays.asList(1, 20, 50, 75, 100, 1000, 10000, 100000, length));
		case 8:
			return new ArrayList<Integer>(Arrays.asList(1, 5, 10, 100, 1000, 10000, 100000, 1000000, 10000000, length));
		case 9:
			return new ArrayList<Integer>(
					Arrays.asList(1, 5, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, length));
		default:
			return null;
		}
	}
}
