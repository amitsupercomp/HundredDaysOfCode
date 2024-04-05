package day52;
import java.util.*;

public class GreatString {
	
	public static void main(String[] args) {
		String s = "leEeetcode";
		System.out.println("Great String :: " + makeGood(s));
	}
	
	private static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char currChar : s.toCharArray()) {
            if (!stack.isEmpty() && Math.abs(stack.lastElement() - currChar) == 32){ 
                stack.pop();
                continue;
            }
                stack.add(currChar);
        }
        StringBuilder ans = new StringBuilder();
        for (char currChar : stack) 
            ans.append(currChar);
        return ans.toString();
    }

}
