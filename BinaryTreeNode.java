package TreeTraversal;

public class BinaryTreeNode {
	
	public int data;
	BinaryTreeNode left, right, parent;
	public int size;
	
	public BinaryTreeNode(int val) {
		data = val;
		left = right = parent = null;
		size = 0;
	}
	
	public BinaryTreeNode() {
		
	}
}
