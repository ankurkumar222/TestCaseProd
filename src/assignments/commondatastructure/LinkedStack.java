package assignments.commondatastructure;

import java.util.LinkedList;
import java.util.Stack;

import assignments.commonutils.CommonUtility;
import util.logs.writer.LogWriter;

class Node<T> {
	T data;
	Node<T> next;

	public Node(T data) {
		this.data = data;
	}
}

public class LinkedStack<T> extends Stack<T> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Node<T> top;
	protected int size;

	public LinkedStack() {
		top = null;
		size = 0;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return size;
	}

	public T push(T data) {
		Node<T> nptr = new Node<T>(data);
		if (top == null) {
			top = nptr;
		} else {
			nptr.next = top;
			top = nptr;
		}
		size++;
		return data;
	}

	public T pop() {
		if (isEmpty()) {
			System.out.println("FAIL");
		}
		Node<T> ptr = top;
		top = ptr.next;
		size--;
		return ptr.data;
	}

	public T peek() {
		if (isEmpty()) {
			System.out.println("FAIL");
		}
		return top.data;
	}

	public void display(String filePath) {

		LogWriter logger = new LogWriter(filePath);
		StringBuilder result = new StringBuilder();
		if (size == 0) {
			// System.out.print("Empty\n");
			return;
		}
		Node<T> ptr = top;
		while (ptr != null) {
			// System.out.print(ptr.data + " ");
			result = result.append(ptr.data + " ");
			ptr = ptr.next;
		}
		// System.out.println();
		String resultString = result.toString();
		logger.writing(resultString);
		CommonUtility.printToConsole(resultString);

	}

	public void displayReverse(String filePath) {

		LogWriter logger = new LogWriter(filePath);
		StringBuilder result = new StringBuilder();
		if (size == 0) {
			// System.out.print("Empty\n");
			return;
		}
		LinkedList<T> list = new LinkedList<>();
		Node<T> ptr = top;
		while (ptr != null) {
			list.add(ptr.data);

			ptr = ptr.next;
		}

		for (int i = list.size() - 1; i >= 0; i--) {
			result = result.append(list.get(i) + " ");
		}

		// System.out.println();
		String resultString = result.toString();
		logger.writing(resultString);
		CommonUtility.printToConsole(resultString);

	}
}
