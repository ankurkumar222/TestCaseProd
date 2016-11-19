package util.other.arrayutility;

import java.util.Random;

public class IntegerUtility {
	public static int generateRandomNumberInRange(int min, int max) {
		//return min + (int) (Math.random() * ((max - min) + 1));
		Random rn = new Random();
		int range = max - min + 1;
		return rn.nextInt(range) + min;
	}
}
