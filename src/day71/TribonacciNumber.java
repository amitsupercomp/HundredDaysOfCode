package day71;

public class TribonacciNumber {
	
	public static void main(String[] args) {
		int n = 13;
		System.out.println("Output :: " + tribonacci(n));
	}
	
	private static int tribonacci(int n) {
        if (n < 3) {
            return n > 0 ? 1 : 0;
        }
        
        int a = 0, b = 1, c = 1;
        for (int i = 0; i < n - 2; ++i) {
            int tmp = a + b + c;
            a = b;
            b = c;
            c = tmp;
        }
        
        return c;
    }

}
