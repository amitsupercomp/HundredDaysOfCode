package day53;
import java.util.*;

public class MinRemToValidParen {
	
	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";
		System.out.println("Output :: " + minRemoveToMakeValid1(s));
		System.out.println("Output :: " + minRemoveToMakeValid(s));
	}

	private static String minRemoveToMakeValid1(String s) {

		int f = 0;
		int l = s.length() - 1;

		String start = "", end = "", result;

		char[] arr = s.toCharArray();
		int open = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(')
				open++;
			else if (arr[i] == ')') {
				if (open == 0)
					arr[i] = '*';
				else
					open--;
			}
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			if (open > 0 && arr[i] == '(') {
				arr[i] = '*';
				open--;
			}
		}
		int p = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != '*')
				arr[p++] = arr[i];
		}

		return new String(arr).substring(0, p);
	}

	private static String minRemoveToMakeValid(String s) {
		Stack<Integer> st = new Stack<>();
		HashSet<Integer> removeIndices = new HashSet<>();

		for (int i = 0;i < s.length(); i++)
		{
			if (s.charAt(i) == '(')
			{
				st.push(i);
			} else if(s.charAt(i) == ')')
			{
				if (!st.empty())
					st.pop();
				else
					removeIndices.add(i);
			}
		}
		while (!st.empty())
			removeIndices.add(st.pop());

		StringBuffer res = new StringBuffer();
		for (int i = 0; i < s.length(); i++)
		{
			if (!removeIndices.contains(i))
				res.append(s.charAt(i));
		}
		return res.toString();

	}

}
