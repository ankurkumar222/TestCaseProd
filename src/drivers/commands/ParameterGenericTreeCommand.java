package drivers.commands;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import util.other.binaryTreeUtil.GenericTreeType;
import util.other.binaryTreeUtil.TreeUtility;

public class ParameterGenericTreeCommand implements ParameterCommand {
	private static final long serialVersionUID = 1L;
	List<Integer> treeListLength;
	private int whatMattersCharacter;
	private int size;
	private int min;
	private int max;

	@Override
	public void menu() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter choice ");
		System.out.println("1: Complete Generic Tree");
		System.out.println("2: Random Generic Tree");
		whatMattersCharacter = s.nextInt();
		System.out.println("No of nodes: ");
		size = s.nextInt();
		System.out.println("Min value of Node element");
		min = s.nextInt();
		System.out.println("Max value of Node element");
		max = s.nextInt();
		treeListLength = ParameterCommandUtil.getArrayListLength(size);
	}

	public ArrayList<Integer> logic(int number) {
		int currentLength = treeListLength.remove(0);
		ArrayList<Integer> treeList = null;
		switch (number) {
		case 1:
			treeList = TreeUtility.takeInputLevelWiseGenericTree(GenericTreeType.COMPLETE_GENERIC_TREE, currentLength, min, max);
			break;
		case 2:
			treeList = TreeUtility.takeInputLevelWiseGenericTree(GenericTreeType.RANDOM_GENERIC_TREE, currentLength, min, max);
			break;
		default:
			return null;
		}
		return treeList;
	}

	@Override
	public void execute(ArrayList<String> result) {
		ArrayList<Integer> ans = logic(whatMattersCharacter);
		StringBuilder stringResult = new StringBuilder("");
		for (int i : ans) {
			stringResult.append(i + " ");
		}
		result.add(stringResult.toString());
	}

	@Override
	public Object read(String line) {
		String[] valueStr = new String(line).trim().split(" ");
		int[] inputArrayParameter = new int[valueStr.length];
		for (int i = 0; i < valueStr.length; i++) {
			if (!valueStr[i].isEmpty()) {
				inputArrayParameter[i] = Integer.parseInt(valueStr[i].trim());
			}
		}
		return inputArrayParameter;
	}

}
