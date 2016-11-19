package drivers.commands;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ParameterCharacterCommand implements ParameterCommand {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int whatMattersCharacter;

	@Override
	public void menu() {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter choice ");
		System.out.println("1: Character [a to z]");
		System.out.println("2: Character [A to Z]");
		System.out.println("3: Character [0 to 9]");
		
		whatMattersCharacter = s.nextInt();
		
	}

	public char logic(int number) {
		Random r = new Random();
		switch (number) {

		case 1:
			String alphabet0 = "abcdefghijklmnopqrstuvwxyz";
			return alphabet0.charAt(r.nextInt(alphabet0.length()));

		case 2:
			String alphabet1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			return alphabet1.charAt(r.nextInt(alphabet1.length()));

		case 3:
			String alphabet2 = "0123456789";
			return alphabet2.charAt(r.nextInt(alphabet2.length()));

		default:
			return '\u0000';

		}

	}

	@Override
	public void execute(ArrayList<String> result) {
		char ans = logic(whatMattersCharacter);
		result.add(ans + "");
	}

	@Override
	public Object read(String line) {
		return line.trim().charAt(0);
	}



}
