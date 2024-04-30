package day77;

public class BitwiseOrSubseqSum {
	
	public static void main(String[] args) {
		int[] nums = {2,1,0,3};
		System.out.println("Output :: " + subsequenceSumOr(nums));
	}
	
	private static long subsequenceSumOr(int[] nums) {
        long res = 0l;
        long prefixSum = 0l;

        for (int num : nums) {
            prefixSum += num;
            res |= num | prefixSum;
        }
        return res;
    }

}
