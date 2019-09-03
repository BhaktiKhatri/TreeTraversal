package TreeTraversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Code from:@yavinci https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34538/My-Accepted-Java-Solution
 * Explanation: https://www.youtube.com/watch?v=2bPquh44uzo
 */

public class ReconstructABinaryTreeFromInOrderAndPreOrder {

	public static BinaryTreeNode binaryTreeFromPreorderInorder(List<Integer> preorder, List<Integer> inorder) {
		Map<Integer, Integer> nodeToInorderIndex = new HashMap<Integer, Integer>();		//key- inorder value; value- index of inorder number in list 
		
		System.out.println("preorder: "+preorder+" inorder: "+inorder);
		
		for(int i=0; i<inorder.size(); ++i) {
			System.out.println("i: "+i+" inorder.get(i): "+inorder.get(i));
			nodeToInorderIndex.put(inorder.get(i), i);
		}
		System.out.println("nodeToInorderIndex: "+nodeToInorderIndex);
		
		return binaryTreeFromInorderPreorderHelper(preorder, 0, preorder.size(), 0, inorder.size(), nodeToInorderIndex);
	}
	
	public static BinaryTreeNode binaryTreeFromInorderPreorderHelper(List<Integer> preorder, int pStart, int pEnd, int iStart, int iEnd, Map<Integer, Integer> nodeToInorderIndex) {
		if(pEnd <= pStart || iEnd <= iStart)
			return null;
		
		System.out.println("pStart: "+pStart+" pEnd: "+pEnd+" iStart: "+iStart+" iEnd: "+iEnd+" nodeToInorderIndex: "+nodeToInorderIndex);
		
		int rootInorderIndex = nodeToInorderIndex.get(preorder.get(pStart));
		int leftSubtreeSize = rootInorderIndex - iStart;
				
		System.out.println("rootInorderIndex: "+rootInorderIndex+" leftSubtreeSize: "+leftSubtreeSize);
		
		BinaryTreeNode root = new BinaryTreeNode(preorder.get(pStart));
		BinaryTreeNode leftChild = binaryTreeFromInorderPreorderHelper(preorder, pStart + 1, pStart + 1 + leftSubtreeSize, iStart, rootInorderIndex, nodeToInorderIndex);
		BinaryTreeNode rightChild = binaryTreeFromInorderPreorderHelper(preorder, pStart + 1 + leftSubtreeSize, pEnd, rootInorderIndex + 1, iEnd, nodeToInorderIndex);
		
		System.out.println("root: "+root.data);
		root.left = leftChild;
		root.right = rightChild;
		if(root.left != null && root.right != null)
			System.out.println("root.left: "+root.left.data+" root.right: "+root.right.data);
		else
			System.out.println("root.left: "+root.left+" root.right: "+root.right);
		return root;
	}
	
	//Refer this
	public static BinaryTreeNode inorderPreorder(int[] preorder, int[] inorder) {
		Map<Integer, Integer> nodeToInorderIdx = new HashMap<Integer, Integer>();
		
		for(int i=0; i<inorder.length; ++i) {
			nodeToInorderIdx.put(inorder[i], i);
		}
		System.out.println(nodeToInorderIdx);
		
		return inorderpreorderHelper(preorder, 0, preorder.length-1, 0, inorder.length-1, nodeToInorderIdx);
	}
	
	public static BinaryTreeNode inorderpreorderHelper(int[] preorder, int pStart, int pEnd, int iStart, int iEnd, Map<Integer, Integer> nodeToInorderIdx) {
		System.out.println("pStart: "+pStart+" pEnd: "+pEnd+" iStart: "+iStart+" iEnd: "+iEnd+" nodeToInorderIdx: "+nodeToInorderIdx);
		
		if(pEnd < pStart || iEnd < iStart)
			return null;
		
		int rootInorderIdx = nodeToInorderIdx.get(preorder[pStart]);
		int leftSubtreeSize = rootInorderIdx - iStart;
		
		System.out.println("rootInorderIndex: "+rootInorderIdx+" leftSubtreeSize: "+leftSubtreeSize);
		
		BinaryTreeNode root = new BinaryTreeNode(preorder[pStart]);
		System.out.println("root: "+root.data);
		
		BinaryTreeNode leftChild = inorderpreorderHelper(preorder, pStart + 1, pStart + leftSubtreeSize, iStart, rootInorderIdx - 1, nodeToInorderIdx);
		BinaryTreeNode rightChild = inorderpreorderHelper(preorder, pStart + 1 + leftSubtreeSize, pEnd, rootInorderIdx + 1, iEnd, nodeToInorderIdx);
		
		System.out.println("root: "+root.data);
		
		root.left = leftChild;
		root.right = rightChild;
		return root;
	}
	
	public static void main(String[] args) {
		List<Integer> inorder = new ArrayList<>();
		inorder.add(9);
		inorder.add(3);
		inorder.add(15);
		inorder.add(20);
		inorder.add(7);

		List<Integer> preorder = new ArrayList<>();
		preorder.add(3);
		preorder.add(9);
		preorder.add(20);
		preorder.add(15);
		preorder.add(7);
		
		//BinaryTreeNode root = binaryTreeFromPreorderInorder(preorder, inorder);
		
		int[] preorder1 = {3,9,20,15,7};
		int[] inorder1 = {9,3,15,20,7};
		
		System.out.println("preorder: "+Arrays.toString(preorder1)+" inorder: "+Arrays.toString(inorder1));
		
		BinaryTreeNode root = inorderPreorder(preorder1, inorder1);
		
		System.out.println("      "+root.data);
		System.out.println("     /"+" \\");
		System.out.println("    "+root.left.data+"  "+root.right.data);
		System.out.println("       /"+" \\");
		System.out.println("      "+root.right.left.data+"  "+root.right.right.data);
	}

}
