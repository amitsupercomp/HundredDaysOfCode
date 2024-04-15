package day62;

import day61.SumLeftNode.TreeNode;

public class SumRootToLeaf {

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

	public static void main(String[] args) {
		TreeNode node = new TreeNode(4);
		node.left = new TreeNode(9);
		node.right = new TreeNode(0);
		node.left.left = new TreeNode(5);
		node.left.right = new TreeNode(1);
		System.out.println("Output :: " + sumNumbers(node));
	}

	private static int sumNumbers(TreeNode root) {
		int rootToLeaf = 0, currNumber = 0;
		int steps;
		TreeNode predecessor;

		while (root != null) {
			if (root.left != null) {
				predecessor = root.left;
				steps = 1;
				while (predecessor.right != null && predecessor.right != root) {
					predecessor = predecessor.right;
					steps++;
				}
				if (predecessor.right == null) {
					currNumber = currNumber * 10 + root.val;
					predecessor.right = root;
					root = root.left;
				}  else {
					if (predecessor.left == null) {
						rootToLeaf += currNumber;
					}
					for(int i = 0; i < steps; ++i) {
						currNumber /= 10;
					}
					predecessor.right = null;
					root = root.right;
				}
			}
			else {
				currNumber = currNumber * 10 + root.val;
				if (root.right == null) {
					rootToLeaf += currNumber;
				}
				root = root.right;
			}
		}
		return rootToLeaf;
	}

}
