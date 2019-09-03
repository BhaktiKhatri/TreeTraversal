package TreeTraversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * WAP that takes as input a binary tree and performs an inorder traversal of the tree iteratively.
 * Page 134
 * Time Complexity: O(n), since total time spent on each node is O(1); Space Complexity: O(h), where h is the height of the tree.
 */

public class InorderTraversalWithoutRecursion {

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
	
	public static List<Integer> BSTInSortedOrder(BinaryTreeNode root) {
		Deque<BinaryTreeNode> queue = new ArrayDeque<>();				//FIFO
		BinaryTreeNode curr = root;
		List<Integer> result = new ArrayList<>();
		
		System.out.println("root: "+root.data);
		
		while(!queue.isEmpty() || curr != null) {
			if(curr != null) {
				System.out.println("in if curr: "+curr.data);
				queue.addFirst(curr); 				
			
				//Going left
				curr = curr.left;
			}
			else {
				//Going up
				curr = queue.removeFirst();
				result.add(curr.data);
				System.out.println("in else curr: "+curr.data);
				//Going right
				curr = curr.right;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		InorderTraversalWithoutRecursion tree = new InorderTraversalWithoutRecursion();
		
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
		
		System.out.println(BSTInSortedOrder(tree.root));
	}

}
