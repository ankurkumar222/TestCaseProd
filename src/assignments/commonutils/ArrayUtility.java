package assignments.commonutils;

import java.util.ArrayList;
import java.util.LinkedList;

import util.logs.writer.LogWriter;
import util.other.binaryTreeUtil.BinaryTreeNode;

public class ArrayUtility {
	public static void print(String ans, String filePath) {

		LogWriter logger = new LogWriter(filePath);
		logger.writing(ans);
		CommonUtility.printToConsole(ans);
	}

	public static void printList(ArrayList<Integer> resultList, String filePath) {
		StringBuilder finalAns = new StringBuilder("");
		for (int i : resultList) {
			finalAns.append(i + " ");
		}
		ArrayUtility.print(finalAns + "", filePath);
	}

	public static void printListln(ArrayList<Integer> resultList, String filePath) {
		StringBuilder finalAns = new StringBuilder("");
		for (int i : resultList) {
			finalAns.append(i);
			finalAns.append(System.lineSeparator());
		}
		ArrayUtility.print(finalAns + "", filePath);
	}

	public static void printToFile(LogWriter logger, String outputString) {
		logger.writing(outputString);
		CommonUtility.printToConsole(outputString);
	}

	public static ArrayList<Integer> arrayToList(int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>(arr.length);
		for (int i : arr) {
			list.add(i);
		}
		return list;
	}

	// print 2d array
	public static void print2DArray(int input[][], String filePath) {
		StringBuilder resultString = new StringBuilder("");
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++) {
				resultString.append(input[i][j] + " ");
			}
			resultString.append("\r\n");
		}
		CommonUtility.printToConsole(resultString.toString());
		LogWriter logger = new LogWriter(filePath);
		logger.writing(resultString.toString());

	}

	public static BinaryTreeNode<Integer> arrayListToBinaryTree(int[] arr) {
		LinkedList<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<BinaryTreeNode<Integer>>();
		int index = 0;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[index++]);
		pendingNodes.add(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			currentNode = pendingNodes.removeFirst();

			if(index>=arr.length){
				break;
			}
			int leftChildData = arr[index++];
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.addLast(leftChild);
			}
			if(index>=arr.length){
				break;
			}
			int rightChildData = arr[index++];
			
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.addLast(rightChild);
			}
		}
		return root;
	}
}
