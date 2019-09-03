package TreeTraversal;

/**
 * Tree Traversal
 * Page 126
 * @author NisuBhakti
 * Time Complexity of each approach is O(n) where n is the number of nodes in the tree. 
 * Although no memory is explicitly allocated, the function call reaches a maximum depth of h, the height of the tree. Thus, space complexity is O(h).
 * The minimum value for h is O(logn) (complete binary tree) and maximum value is n (skewed tree).
 */

public class TreeTraversal {

	BinaryTreeNode root;
	
	public static void preorderTraversal(BinaryTreeNode root) {
		if(root == null)
			return;
		
		System.out.print(" "+root.data);
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}
	
	public static void inorderTraversal(BinaryTreeNode root) {
		if(root == null)
			return;
		
		inorderTraversal(root.left);
		System.out.print(" "+root.data);
		inorderTraversal(root.right);
	}
	
	public static void postorderTraversal(BinaryTreeNode root) {
		if(root == null)
			return;
		
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		System.out.print(" "+root.data);
	}
	
	public static void main(String[] args) {
		TreeTraversal tree = new TreeTraversal();
//		tree.root = new BinaryTreeNode(1);
//		tree.root.left = new BinaryTreeNode(2);
//		tree.root.left.left = new BinaryTreeNode(4);
//		tree.root.right = new BinaryTreeNode(3);
//		tree.root.right.left = new BinaryTreeNode(5);
//		tree.root.right.left.left = new BinaryTreeNode(7);
//		tree.root.right.right = new BinaryTreeNode(6);
		
		tree.root = new BinaryTreeNode(3);
		tree.root.left = new BinaryTreeNode(9);
		tree.root.right = new BinaryTreeNode(20);
		tree.root.right.left = new BinaryTreeNode(15);
		tree.root.right.right = new BinaryTreeNode(7);
		
		System.out.println("Preorder Traversal!");
		preorderTraversal(tree.root);
		System.out.println();
		
		System.out.println("Inorder Traversal!");
		inorderTraversal(tree.root);
		System.out.println();
		
		System.out.println("Postorder Traversal!");
		postorderTraversal(tree.root);
		System.out.println();
		
	}

}