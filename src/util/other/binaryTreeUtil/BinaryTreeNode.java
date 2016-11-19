package util.other.binaryTreeUtil;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class BinaryTreeNode<T> {

	OutputStreamWriter outputStreamWriter;
	public T data;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
	}
	public void printTree(OutputStreamWriter out) throws IOException {
		this.outputStreamWriter = out;
		if (right != null) {
			right.printTree(out, true, "");
		}
		printNodeValue(out);
		if (left != null) {
			left.printTree(out, false, "");
		}
	}

	private void printNodeValue(OutputStreamWriter out) throws IOException {
		if (data == null) {
			out.write("<null>");
		} else {
			out.write(data+"");
		}
		out.write('\n');
	}
	private void printTree(OutputStreamWriter out, boolean isRight, String indent) throws IOException {
	        if (right != null) {
	            right.printTree(out, true, indent + (isRight ? "        " : " |      "));
	        }
	        out.write(indent);
	        if (isRight) {
	            out.write(" /");
	        } else {
	            out.write(" \\");
	        }
	        out.write("----- ");
	        printNodeValue(out);
	        if (left != null) {
	            left.printTree(out, false, indent + (isRight ? " |      " : "        "));
	        }
	    }
}
