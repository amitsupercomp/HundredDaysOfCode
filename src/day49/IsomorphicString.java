package day49;
import java.util.*;
public class IsomorphicString {

	public static void main(String[] args) {
		String a = "paper", b = "title";
		System.out.println("String a = " + a + " and b = " + b + " \n is isomorphic :: " + isIsomorphic(a, b));
	}

	private static boolean isIsomorphic(String s, String t) {
		int ns = s.length();
		int nt = t.length();
		if (ns != nt)
			return false;
		int[] characterS = new int[256];
		int[] characterT = new int[256];

		Arrays.fill(characterS, -1);
		Arrays.fill(characterT, -1);

		for (int i = 0; i < nt; i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			if (characterS[cs] == -1 && 
					characterT[ct] == -1) {
				characterS[cs] = ct;
				characterT[ct] = cs;
			} else if (!(characterS[cs] == ct && characterT[ct] == cs))
				return false;
		}
		return true;

	}

}
