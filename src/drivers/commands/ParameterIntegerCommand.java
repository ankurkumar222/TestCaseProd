package drivers.commands;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ParameterIntegerCommand implements ParameterCommand {

	private static final long serialVersionUID = 1L;
	private int whatMattersInteger;
	private int min;
	private int max;

	@Override
	public void menu() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter choice ");
		System.out.println("1: Zero");
		System.out.println("2: Positive");
		System.out.println("3: Negative");
		System.out.println("4: Max Integer Value");
		System.out.println("5: Min Integer Value");
		whatMattersInteger = s.nextInt();
		if (whatMattersInteger == 2 || whatMattersInteger == 3) {
			System.out.println("Enter Range:");
			System.out.println("MIN:");
			min = s.nextInt();
			System.out.println("MAX:");
			max = s.nextInt();
		}
	}

	public int logic(int number) {
		switch (number) {
		case 1:
			return 0;
		case 2:
			return Math.abs(randInt(min, max));
		case 3:
			return -Math.abs(randInt(min, max));
		case 4:
			return Integer.MAX_VALUE;
		case 5:
			return Integer.MIN_VALUE;
		default:
			return -1;
		}
	}

	@Override
	public void execute(ArrayList<String> result) {
		int ans = logic(whatMattersInteger);
		result.add(ans + "");
	}

	@Override
	public Integer read(String line) {
		String[] valueStr = new String(line).trim().split(" ");
		return Integer.parseInt(valueStr[0]);
	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((Math.abs(max) - Math.abs(min)) + 1) + Math.abs(min);
		return randomNum;
	}
}
