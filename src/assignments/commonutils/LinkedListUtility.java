package assignments.commonutils;

import assignments.questions.linkedlist.LinkedListNode;
import util.logs.writer.LogWriter;

public class LinkedListUtility {
	public static LinkedListNode<Integer> arrayToLinkedList(int arr[]) {
		LinkedListNode<Integer> head = null;
		LinkedListNode<Integer> tail = null;
		for (int i = 0; i < arr.length; i++) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(arr[i]);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}
		}
		return head;
	}

	public static void printList(LinkedListNode<Integer> head, String filePath) {
		LinkedListNode<Integer> temp= head;
		StringBuilder outputString = new StringBuilder("");
		while (temp != null) {
			outputString.append(temp.getData() + " ");
			temp = temp.next;
		}
		LogWriter logger = new LogWriter(filePath);
		logger.writing(outputString.toString());
		printonScreen(head);
	}

	public static void printonScreen(LinkedListNode<Integer> head){
		int count =0;
		while (head != null&&count<10) {
			System.out.print(head.getData() + " ");
			head = head.next;
			count++;
		}
		
		if(head!=null){
			System.out.print(" Continue....");
		}
		System.out.println();
	}
	
	public static void print(String ans, String filePath) {
		LogWriter logger = new LogWriter(filePath);
		logger.writing(ans);
		CommonUtility.printToConsole(ans);
	}
	public static int length(LinkedListNode<Integer> head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}
		return count;
	}
}
