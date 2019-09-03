package TreeTraversal;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalWithO1Space {

	BinaryTreeNode root;
	
	public static List<Integer> inorderTraversal(BinaryTreeNode root) {
		BinaryTreeNode curr = root;
		BinaryTreeNode prev = null;
		List<Integer> result = new ArrayList<>();

		System.out.println("root: "+root.data);
		
		while(curr != null) {
			
			System.out.println("curr: "+curr.data+" curr.parent: "+curr.parent+" prev: "+prev);
			BinaryTreeNode next;
			
			if(curr.parent == prev) {
				//We came down to curr from prev
				if(curr.left != null) {				//Keep going left
					System.out.println("in if curr.left: "+curr.left.data);
					next = curr.left;
				}
				else {
					System.out.println("in if curr: "+curr.data+" curr.parent: "+curr.parent+" curr.right: "+curr.right+" result: "+result);
					result.add(curr.data);
					//Done with left, so so right if right is not empty; otherwise go up
					next = (curr.right != null) ? curr.right : curr.parent;
					System.out.println("next: "+next.data);
				}
			}
			else if(curr.left == prev) {	//eg 1.left = 2 = prev so add 1 into result and go to 1.right ie 3 as 1.parent is null
				System.out.println("in else if curr: "+curr.data+" curr.parent: "+curr.parent+" curr.right: "+curr.right+" result: "+result);
				result.add(curr.data);
				//Done with left, so go right if right is not empty; otherwise go up
				next = (curr.right != null) ? curr.right : curr.parent;
				System.out.println("in else if next: "+next.data);
			}
			else {		//traversed and added in result Left-Root-Right i.e. 4-2-9-8 so now go to 1 i.e root of Left
				System.out.println("in else curr.parent: "+curr.parent);
				next = curr.parent;
				System.out.println("next: "+next);
			}
			System.out.println("in while curr: "+curr.data+" prev: "+prev+" next: "+next);
			prev = curr;
			curr = next;
		}
		return result;
	}
	
	public static void main(String[] args) {
		InorderTraversalWithO1Space tree = new InorderTraversalWithO1Space();
		
/*
		   1
		 /   \
		2      3
	  /  \     / \
	 4    8    5  6
	     /    /
	    9     7
*/
		
		tree.root = new BinaryTreeNode(1);
		tree.root.left = new BinaryTreeNode(2);
		tree.root.left.right = new BinaryTreeNode(8);
		tree.root.left.right.left = new BinaryTreeNode(9);
		tree.root.left.left = new BinaryTreeNode(4);
		tree.root.right = new BinaryTreeNode(3);
		tree.root.right.left = new BinaryTreeNode(5);
		tree.root.right.left.left = new BinaryTreeNode(7);
		tree.root.right.right = new BinaryTreeNode(6);
		
		tree.root.left.parent = tree.root;
		tree.root.left.left.parent = tree.root.left;
		tree.root.right.parent = tree.root;
		tree.root.right.left.parent = tree.root.right;
		tree.root.right.left.left.parent = tree.root.right.left;
		tree.root.right.right.parent = tree.root.right;
		tree.root.left.right.parent = tree.root.left;
		tree.root.left.right.left.parent = tree.root.left.right;
		
		System.out.println(inorderTraversal(tree.root));

	}

}
