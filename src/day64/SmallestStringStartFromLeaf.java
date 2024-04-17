package day64;

public class SmallestStringStartFromLeaf {
	
	String result = "";
	
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
		TreeNode node = new TreeNode(7);
		node.left = new TreeNode(1);
		node.right = new TreeNode(5);
		node.right.left = new TreeNode(8);
		node.right.right = new TreeNode(4);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(9);
		new SmallestStringStartFromLeaf().smallestFromLeaf(node);
		
	}

	private String smallestFromLeaf(TreeNode root) {
		operate(root, new StringBuilder());
		return result;
	}

	private void operate(TreeNode root, StringBuilder currStr) {
		if (root == null)
			return;
		currStr.insert(0, (char) ('a' + root.val));
		if (root.left == null && root.right == null) {
			if (result == null || currStr.toString().compareTo(result) < 0)
				result = currStr.toString();
		} else {
			operate(root.left, currStr);
			operate(root.right, currStr);
		}
		currStr.deleteCharAt(0);
	}

}
