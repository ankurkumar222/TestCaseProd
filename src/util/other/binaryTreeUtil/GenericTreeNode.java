package util.other.binaryTreeUtil;

import java.util.ArrayList;

public class GenericTreeNode<T> {

	public T data;
	public ArrayList<GenericTreeNode<T>> children;

	GenericTreeNode(T data) {
		this.data = data;
		children = new ArrayList<>();
	}

}
