package day65;
import java.util.*;

public class LonelyNodes {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	static List<Integer> result;
	
	private static List<Integer> getLonelyNodes(TreeNode root) {
		result = new ArrayList<>();
		traverse(root);
		return result; 
	}
	private static void traverse(TreeNode root) {
		if (root == null) {
			return;
		}

		if (root.left == null) {
			if (root.right != null){
				result.add(root.right.val);
			}
		}

		if (root.right == null) {
			if (root.left != null) {
				result.add(root.left.val);
			}
		}

		traverse(root.left);
		traverse(root.right);
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.right = new TreeNode(4);
		System.out.println("Lonely Nodes :: " + getLonelyNodes(node) );
	}

}
