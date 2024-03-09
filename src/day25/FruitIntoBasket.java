package day25;
import java.util.*;
public class FruitIntoBasket {
	public static void main(String[] args) {
		int[] fruits = {1,2,3,2,2};
		System.out.println("Using Brute Force I Approach     :: " + totalFruitBruteForceI(fruits));
		System.out.println("Using Brute Force II Approach    :: " + totalFruitsBruteForceII(fruits));
		System.out.println("Using Sliding Window I Approach  :: " + totalFruitsSlidingWinI(fruits));
		System.out.println("Using Sliding Window II Approach :: " + totalFruitsSlidingWinII(fruits));
		
	}

	private static int totalFruitBruteForceI(int[] fruits) {
		int maxPick = 0;
		for (int left = 0; left < fruits.length; left++) {
			for (int right = 0; right < fruits.length; right++) {
				Set<Integer> basket = new HashSet<>();
				for (int currentIndex = left; currentIndex <= right; ++currentIndex) {
					basket.add(fruits[currentIndex]);
				}
				if (basket.size() <= 2)
					maxPick = Math.max(maxPick, right - left + 1);
			}
		}
		return maxPick;
	}

	private static int totalFruitsBruteForceII(int[] fruits) {
		int maxPick = 0;
		for (int left = 0; left < fruits.length; left++) {
			Set<Integer> basket = new HashSet<>();
			int right = left;
			while (right < fruits.length) {
				if (!basket.contains(fruits[right]) && basket.size() == 2)
					break;
				basket.add(fruits[right]);
				right++;
			}
			maxPick = Math.max(maxPick, right - left);
		}
		return maxPick;
	}

	private static int totalFruitsSlidingWinI(int[] fruits) {
		Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, right;

        for (right = 0; right < fruits.length; right++) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            if (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
            if (basket.get(fruits[left]) == 0)
                basket.remove(fruits[left]);
            left++;
            }
        }
        return right - left;
	}

	private static int totalFruitsSlidingWinII(int[] fruits) {
		Map<Integer, Integer> basket = new HashMap<>();
        int left = 0, maxPick = 0;

        for (int right = 0; right < fruits.length; right++) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);
            while (basket.size() > 2) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0)
                    basket.remove(fruits[left]);
                left++;
            }

            maxPick = Math.max(maxPick, right - left + 1);
        }
        return maxPick;
	}
}
