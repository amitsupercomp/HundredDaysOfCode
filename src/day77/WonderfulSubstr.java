package day77;

public class WonderfulSubstr {
	
	public static void main(String[] args) {
		String word = "aabb";
		System.out.println("Output :: " + wonderfulSubstrings(word));
	}
	
	private static long wonderfulSubstrings(String word) {
        // long res = 0l;
        // int n = word.length();
        // Map<Integer, Integer> freq = new HashMap<>();
        // freq.put(0, 1);
        // int mask = 0;
        // for (int i = 0; i < n; i++) {
        //     char c = word.charAt(i);
        //     int bit = c - 'a';
        //     mask ^= (1 << bit);
        //     res += freq.getOrDefault(mask, 0);
        //     freq.put(mask, freq.getOrDefault(mask, 0) + 1);
        //     for (int odd_c=0; odd_c < 10; odd_c++) {
        //         res += freq.getOrDefault(mask ^ (1 << odd_c),0);
        //     }
        // }
        // return res;

        int count[] = new int[1024];
        int mask = 0;
        count[0] = 1;
        long result = 0;
        for(char c : word.toCharArray()) {
            mask ^= 1 << (c - 'a');
            result += count[mask]; //even
            for(int i = 0; i < 10; i++) {
                result += count[mask ^ (1 << i)];
            }
            count[mask]++;
        }
        return result;
    }

}
