package day76;

public class MinOprArrXor {
	
	public static void main(String[] args) {
		int k = 1;
		int[] arr = {2,1,3,4};
		System.out.println("Minimum Operation :: " + minOperations(arr, k));
	}
	
	private static int minOperations(int[] nums, int k) {
        int finalXORValue = 0;
        for (int n : nums)
            finalXORValue = finalXORValue ^ n;
        int res = 0;
        while (k > 0 || finalXORValue > 0) {
            if (k % 2 != finalXORValue % 2)
                res++;
            k /= 2;
            finalXORValue /= 2;
        }
        return res;
    }

}
