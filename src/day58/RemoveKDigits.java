package day58;
import java.util.*;

public class RemoveKDigits {
	
	public static void main(String[] args) {
		String num = "1432219";
		int k = 3;
		System.out.println("Output :: " + removeKdigits(num, k));
	}
	
	private static String removeKdigits(String num, int k) {
        LinkedList<Character> list = new LinkedList<>();

        for (char digit : num.toCharArray()) {
            while (list.size() > 0 && k > 0 && list.peekLast() > digit) {
                list.removeLast();
                k -= 1;
            }
            list.addLast(digit);
        }

        for (int i = 0; i < k; i++)
            list.removeLast();

        StringBuilder str = new StringBuilder();
        boolean leadZ = true;

        for (char digit : list) {
            if (leadZ && digit == '0')
                continue;
            leadZ = false;
            str.append(digit);
        }

        if (str.length() == 0)
            return "0";
        return str.toString();
    }

}
