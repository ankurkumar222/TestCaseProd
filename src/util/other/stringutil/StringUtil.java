package util.other.stringutil;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class StringUtil {
	public static enum StringType {
		CAPITAL, SMALL, NUMERIC, ALPHANUMERIC
	}

	private static final String symbols_AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String symbols_ab = "abcdefghijklmnopqrstuvwxyz";
	private static final String symbol_Numeric ="0123456789";
	private static final String symbols_ABab = "abcdefghiABCDEFGHIJKLMNjklmnopqrstuvwxyzOPQRSTUVWXYZ";
	private static final String symbolAlphaNumeric = "01234abcdefghiABCDEFGHIJKLMN567890jklmnopqrstuvwxyzOPQRSTUVWXYZ!@#$%^&*()-+";
	static HashSet<String> stringSet = new HashSet<>();
	final static String str = "abcdefghijklmnopqrstuvwxyz";

	public static String generateUniqueStringOfGivenLength(int length) {
		for (int i = 0; i < str.length(); i++) {
			for (int j = i + 1; j < str.length(); j++) {
				permutation(str.substring(i, j), "", stringSet);
				if (stringSet.size() > length) {
					break;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (String currentString : stringSet) {
	        sb.append(currentString+" ");
	     }
		return sb.toString();
	}

	public static String generatePermutationOfString(String input) {
		HashSet<String> set = new HashSet<>();
		permutation(input, "", set);
		int index = (new Random()).nextInt(set.size());
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			return it.next();
		}
		return null;
	}

	private static void permutation(String input, String resultSoFar, HashSet<String> set) {
		if (input.length() == 0) {
			set.add(resultSoFar);
			return;
		}
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			String newResultSoFar = resultSoFar + ch;
			String newInput = input.substring(0, i) + input.substring(i + 1);
			permutation(newInput, newResultSoFar, set);
		}
	}

	public static void main(String[] args) {
		String str = generateUniqueStringOfGivenLength(1000000);
		System.out.println(str);
	}

	public static String getRequiredString(final int length, StringType stringType) {
		StringBuilder sb = new StringBuilder();

		switch (stringType) {
		case SMALL:
			for (int i = 0; i < length; i++) {
				char c = symbols_ab.charAt((new Random()).nextInt(symbols_ab.length()-1));
				sb.append(c);
			}
			break;
		case CAPITAL:
			for (int i = 0; i < length; i++) {
				char c = symbols_AB.charAt((new Random()).nextInt(symbols_AB.length()-1));
				sb.append(c);
			}
			break;
		case NUMERIC:
			for (int i = 0; i < length; i++) {
				char c = symbol_Numeric.charAt((new Random()).nextInt(symbol_Numeric.length()-1));
				sb.append(c);
			}
			break;
		case ALPHANUMERIC:
			for (int i = 0; i < length; i++) {
				char c = symbolAlphaNumeric.charAt((new Random()).nextInt(symbolAlphaNumeric.length()-1));
				sb.append(c);
			}
			break;
		default:
			 break;
		}
		
		return sb.toString();
	}
}
