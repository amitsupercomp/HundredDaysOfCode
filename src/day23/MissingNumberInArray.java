package day23;

public class MissingNumberInArray {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,5};
		System.out.println("Missing Number is :: " + missingNumber(arr, arr.length));
	}
	
	private static int missingNumber(int array[], int n) {
        // Your Code Here
        
        int sumOfTotal = n * (n + 1) / 2;
        int sumOfPresent = 0;
        
        for (int i = 0; i < n - 1; i++) {
            sumOfPresent += array[i];
        }
        
        return sumOfTotal - sumOfPresent;
    }
	
}
