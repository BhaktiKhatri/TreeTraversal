package TreeTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructABinaryTreeFromInorderAndPostorder {

	/*
		  Just clarify how to get the start and end index for postorder array in the recursion call. When we find the root index inIndex, we can get the
		  number of nodes in the left subtree, that is, (inIndex - 1) - inStart(Actually it is the number of nodes in the left subtree - 1, but that number
		  will be added to postStart + 1. So 1 is canceled. It’s a little bit confusing here.) Then, the postorder array will be cut into two subarrays whose 
		  index range are [postStart, postStart + ((inIndex - 1) - inStart)] and [(postStart + (inIndex - 1) - inStart) + 1, postEnd - 1]. Simplify: 
		  [postStart, postStart + inIndex - inStart - 1], [postStart + inIndex - inStart, postEnd - 1]. 
	*/
	
	public static BinaryTreeNode binaryTreeFromPostorderInorder(List<Integer> postorder, List<Integer> inorder) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		System.out.println("postorder: "+postorder+" inorder: "+inorder);
		
		for(int i=0; i<inorder.size(); ++i) {
			map.put(inorder.get(i), i);			//key- inorder node value; value- index of node in inorder list
		}
		
		return binaryTreeInorderPostorderHelper(postorder, 0, postorder.size()-1, 0, inorder.size()-1, map);
	}
	
	public static BinaryTreeNode binaryTreeInorderPostorderHelper(List<Integer> postorder, int pStart, int pEnd, int iStart, int iEnd, Map<Integer, Integer> map) {
		if(pEnd < pStart || iEnd < iStart)
			return null;
		
		System.out.println("pStart: "+pStart+" pEnd: "+pEnd+" iStart: "+iStart+" iEnd: "+iEnd+" map: "+map);
		
		int rootInorderIndex = map.get(postorder.get(pEnd));
		int leftSubtreeSize = rootInorderIndex - iStart;
		
		System.out.println("rootInorderIndex: "+rootInorderIndex+" leftSubtreeSize: "+leftSubtreeSize);
		
		BinaryTreeNode root = new BinaryTreeNode(postorder.get(pEnd));
		
		BinaryTreeNode leftChild = binaryTreeInorderPostorderHelper(postorder, pStart, pStart + leftSubtreeSize - 1, iStart, rootInorderIndex-1, map);
		BinaryTreeNode rightChild = binaryTreeInorderPostorderHelper(postorder, pStart + leftSubtreeSize, pEnd - 1, rootInorderIndex + 1, iEnd, map);
		
		root.left = leftChild;
		root.right = rightChild;
				
		return root;
	}
	
	public static BinaryTreeNode buildTree(int[] postorder, int[] inorder) {
		Map<Integer, Integer> nodeToInorderIndex = new HashMap<Integer, Integer>();
		
		for(int i=0; i<inorder.length; ++i) {
			nodeToInorderIndex.put(inorder[i], i);
		}
		
		return buildTreeHelper(postorder, 0, postorder.length-1, 0, inorder.length-1, nodeToInorderIndex);
	}
	
	public static BinaryTreeNode buildTreeHelper(int[] postorder, int pStart, int pEnd, int iStart, int iEnd, Map<Integer, Integer> nodeToInorderIndex) {
		
		if(pEnd < pStart || iEnd < iStart)
			return null;
		
		int rootInorderIndex = nodeToInorderIndex.get(postorder[pEnd]);
		int leftSubtreeSize = rootInorderIndex - iStart;
		
		BinaryTreeNode root = new BinaryTreeNode(postorder[pEnd]);
		
		BinaryTreeNode leftChild = buildTreeHelper(postorder, pStart, pStart + leftSubtreeSize - 1, iStart, rootInorderIndex, nodeToInorderIndex);
		BinaryTreeNode rightChild = buildTreeHelper(postorder, pStart + leftSubtreeSize, pEnd - 1, rootInorderIndex + 1, iEnd, nodeToInorderIndex);
		
		root.left = leftChild;
		root.right = rightChild;
				
		return root;
	}
	
	public static void main(String[] args) {
//		int[] preorder = {3,9,20,15,7};
//		int[] inorder = {9,3,15,20,7};
//		int[] postorder = {9,15,7,20,3};
		
		List<Integer> inorder = new ArrayList<>();
		inorder.add(9);
		inorder.add(3);
		inorder.add(15);
		inorder.add(20);
		inorder.add(7);

		List<Integer> postorder = new ArrayList<>();
		postorder.add(9);
		postorder.add(15);
		postorder.add(7);
		postorder.add(20);
		postorder.add(3);
		
		BinaryTreeNode root = binaryTreeFromPostorderInorder(postorder, inorder);
		
		System.out.println("      "+root.data);
		System.out.println("     /"+" \\");
		System.out.println("    "+root.left.data+"  "+root.right.data);
		System.out.println("       /"+" \\");
		System.out.println("      "+root.right.left.data+"  "+root.right.right.data);
	}

}
