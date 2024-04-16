package day63;
import java.util.*;

public class AddOneRow {

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
		node.left = new TreeNode(2);
		node.right = new TreeNode(6);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(1);
		node.right.left = new TreeNode(5);
		int val = 1, depth = 2;
		TreeNode result = addOneRow(node, val, depth);
		//result is the final tree. 

	}	

	private static TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (depth == 1) {
			TreeNode tn = new TreeNode(val);
			tn.left = root;
			return tn;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int d = 1;
		while (d < depth - 1) {
			Queue<TreeNode> temp = new LinkedList<>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.remove();
				if (node.left != null) temp.add(node.left);
				if (node.right != null) temp.add(node.right);
			}
			queue = temp;
			d++;
		}
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			TreeNode temp = node.left;
			node.left = new TreeNode(val);
			node.left.left = temp;
			temp = node.right;
			node.right = new TreeNode(val);
			node.right.right = temp; 
		}
		return root;
	}

}
