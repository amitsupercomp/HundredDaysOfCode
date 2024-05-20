package day97;

public class XORAllSubset {
	
	public static void main(String[] args) {
		int[] arr = {5,1,6};
		System.out.println("Output :: " + subsetXORSum(arr));
	}
	
	private static int subsetXORSum(int[] nums) {
        int res = 0;
        for (int num : nums)
            res |= num;
        return res << (nums.length - 1);
    }

}
