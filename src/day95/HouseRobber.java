package day95;

public class HouseRobber {
	
	public static void main(String[] args) {
		int[] nums = {2,7,9,3,1};
		System.out.println("Output :: " + rob(nums));
	}
	
	private static int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        int[] maxAmount = new int[nums.length + 1];
        maxAmount[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; --i) {
            maxAmount[i] = Math.max(maxAmount[i + 1], maxAmount[i + 2] + nums[i]);
        }
        return maxAmount[0];
    }

}
