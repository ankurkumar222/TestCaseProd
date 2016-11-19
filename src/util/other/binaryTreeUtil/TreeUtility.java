package util.other.binaryTreeUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import util.other.arrayutility.IntegerArrayUtility;

public class TreeUtility {

	public static BinaryTreeNode<Integer> sortedArrayToBST(int arr[], int start, int end) {

		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		BinaryTreeNode<Integer> node = new BinaryTreeNode<Integer>(arr[mid]);
		node.left = sortedArrayToBST(arr, start, mid - 1);
		node.right = sortedArrayToBST(arr, mid + 1, end);
		return node;
	}

	private static ArrayList<Integer> constructCompleteBinaryTree(ArrayList<Integer> list, int min, int max) {
		Random rn = new Random();
		ArrayList<Integer> result = new ArrayList<>();
		int count = 1;
		for (int levelNodes : list) {
			for (int i = 0; i < levelNodes; i++) {
				if (count == list.size()) {
					result.add(-1);
				} else {
					int num = rn.nextInt(max - min + 1) + min;
					result.add(num);
				}
			}
			count++;
		}
		return result;
	}

	static Scanner s = new Scanner(System.in);

	private static ArrayList<Integer> constructRandomBinaryTree(int size, int min, int max) {
		ArrayList<Integer> result = new ArrayList<>();
		LinkedList<Integer> queue = new LinkedList<>();
		queue.addLast(getRandomNumber(min, max));

		int count = 1;
		while (!queue.isEmpty()) {
			int currentNode = queue.removeFirst();
			if (count >= size) {
				result.add(currentNode);
				if (currentNode != -1) {
					result.add(-1);
					result.add(-1);
				}
				continue;
			}

			result.add(currentNode);
			if (currentNode == -1) {
				continue;
			}
			int leftChildData = getRandomNumber(0, 6) == 0 ? -1 : getRandomNumber(min, max);
			if (leftChildData != -1) {
				count++;
			}

			queue.addLast(leftChildData);
			int rightChildData = getRandomNumber(0, 6) == 0 ? -1 : getRandomNumber(min, max);
			if (rightChildData != -1) {
				count++;
			}
			queue.addLast(rightChildData);
		}
		return result;
	}

	private static int getRandomNumber(int min, int max) {
		Random rn = new Random();
		return rn.nextInt(max - min) + min;
	}

	public static ArrayList<Integer> constructBinaryTreeLevelWise(BinaryTreeType treeType, int size, int min, int max) {
		ArrayList<Integer> list = new ArrayList<>();

		switch (treeType) {
		case COMPLETE_BINARY_TREE:
			int level = 0;
			int arr[] = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072,
					262144, 524288, 1048576 };
			while (level != size) {
				list.add(arr[level++]);
			}
			list = constructCompleteBinaryTree(list, min, max);
			break;

		case RANDOM_BINARY_TREE:
			list = constructRandomBinaryTree(size, min, max);
			break;

		case COMPLETE_BST:
			int sortedArr[] = IntegerArrayUtility.increasingIntegerArray(size, min, max);
			BinaryTreeNode<Integer> tree = sortedArrayToBST(sortedArr, 0, sortedArr.length - 1);
			list = levelOrderTraversalStorage(tree);
			break;
		default:
			break;
		}
		return list;
	}

	private static ArrayList<Integer> levelOrderTraversalStorage(BinaryTreeNode<Integer> root) {
		ArrayList<Integer> list = new ArrayList<>();
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> tempNode = queue.poll();
			if (tempNode == null) {
				list.add(-1);
				continue;
			}
			list.add(tempNode.data);
			if (tempNode.left != null) {
				queue.add(tempNode.left);
			} else {
				queue.add(null);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			} else {
				queue.add(null);
			}
		}
		return list;
	}

	// generic tree from an array
	public static ArrayList<Integer> takeInputLevelWiseGenericTree(GenericTreeType treeType, int size, int min,
			int max) {
		// need to create an array of sum of all array will be equal to size...
		ArrayList<Integer> list = new ArrayList<>();
		Random rn = new Random();
		switch (treeType) {
		case COMPLETE_GENERIC_TREE:
			while (true) {
				int randomNum = rn.nextInt(9) + 1;
				size = size - randomNum;
				if (size <= 0) {
					break;
				}
				list.add(randomNum);
			}
		case RANDOM_GENERIC_TREE:
			while (true) {
				int randomNum = rn.nextInt(10);
				size = size - randomNum;
				if (size <= 0) {
					break;
				}
				list.add(randomNum);
			}
		}
		ArrayList<Integer> result = new ArrayList<>();
		result.add(rn.nextInt(max - min + 1) + min);
		for (int numChild : list) {
			result.add(numChild);
			for (int i = 0; i < numChild; i++) {
				int rootData = rn.nextInt(max - min + 1) + min;
				result.add(rootData);
			}
		}
		return result;
	}
}
