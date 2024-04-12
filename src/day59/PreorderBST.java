package day59;

public class PreorderBST {
	
	public static void main(String[] args) {
		int[] arr = new int[] {5,2,1,3,6};
		System.out.println("Output :: " + verifyPreorder(arr));
	}

	private static boolean verifyPreorder(int[] preorder) {
		int min = Integer.MIN_VALUE;
		int i = 0;

		for (int val : preorder) {
			while (i > 0 && preorder[i - 1] < val) {
				min = preorder[i - 1];
				i--;
			}
			if (val <= min)
				return false;
			preorder[i] = val;
			i++;
		}
		return true;
	}

}
