package day61;

public class SumLeftNode {

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
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		System.out.println("Output :: " + sumOfLeftLeaves(node));
	}
	
	private static int sumOfLeftLeaves(TreeNode root) {
        int totalSum = 0;
       TreeNode currentNode = root;
        while (currentNode != null) {
           if (currentNode.left == null) {
       currentNode = currentNode.right;
     } else {
       TreeNode previous = currentNode.left;
       // Check if this left node is a leaf node.
       if (previous.left == null && previous.right == null) {
         totalSum += previous.val;
       }
        while (previous.right != null && !previous.right.equals(currentNode)) {
         previous = previous.right;
       }
        if (previous.right == null) {
         previous.right = currentNode;
         currentNode = currentNode.left;
       }
        else {
         previous.right = null;
         currentNode = currentNode.right;
       }
        }
        }
        return totalSum;
   }

}
