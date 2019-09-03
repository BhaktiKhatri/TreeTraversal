package TreeTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Implement a preorder traversal without recursion
 * Page 135
 * @author NisuBhakti
 * Time Complexity: O(n), since we push and pop each element exactly once, where n is the number of nodes; Space Complexity: O(h)
 */

public class PreorderTraversalWithoutRecursion {

	BinaryTreeNode root;
	
/*
			   1
			  / \
			 2   3
			/   / \
		   4    5  6
			   /
			  7
*/
	
	public static List<Integer> preorderTraversal(BinaryTreeNode root) {
		Deque<BinaryTreeNode> queue = new ArrayDeque<>();
		List<Integer> result = new ArrayList<>();
		
		System.out.println("root: "+root.data);
		
		if(root != null)
			queue.addFirst(root);
		
		while(!queue.isEmpty()) {
		
			BinaryTreeNode curr = queue.removeFirst();
			result.add(curr.data);
			
			System.out.println("curr: "+curr.data+" result: "+result);
			
			if(curr.right != null) {
				System.out.println("curr.right: "+curr.right.data);
				queue.addFirst(curr.right);
			}
			
			if(curr.left != null) {
				System.out.println("curr.left: "+curr.left.data);
				queue.addFirst(curr.left);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		PreorderTraversalWithoutRecursion tree = new PreorderTraversalWithoutRecursion();
		
		/*
		 					   1
		 					  / \
		 					 2   3
		 					/   / \
		 				   4    5  6
		 				       /
		 				       7
		 */
		
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.right = new BinaryTreeNode(3);
		tree.root.right.left = new BinaryTreeNode(5);
		tree.root.right.left.left = new BinaryTreeNode(7);
		tree.root.right.right = new BinaryTreeNode(6);
		
		System.out.println(preorderTraversal(tree.root));
	}

}
