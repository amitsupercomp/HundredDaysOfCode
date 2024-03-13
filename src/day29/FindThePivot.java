package day29;

import java.util.Scanner;

public class FindThePivot {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = scanner.nextInt();
		int pivot = pivotInteger(n);
		if (pivot == -1)
			System.out.println("Pivot does not exist");
		else 
			System.out.println("Pivot element of " + n + " is :: " + pivot);
	}
	
	private static int pivotInteger(int n) {
		int pivot = -1;
		int firstSum = 1, lastSum = n;
		int i = 1, j = n;
		while (i <= j) {
			if (firstSum == lastSum && i == j) {
				if (firstSum == 1)
					return 1;
				pivot = i ;
				return pivot;
			} else if (firstSum < lastSum) {
				++i;
				firstSum += i;
			} else {
				j--;
				lastSum += j;
			}
		}
		return pivot;
	}
}
