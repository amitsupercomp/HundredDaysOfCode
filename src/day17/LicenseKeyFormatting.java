package day17;

public class LicenseKeyFormatting {

	public static void main(String[] args) {
		String s = "5F3Z-2e-9-w";
		int k = 4;
		System.out.println("Output is :: " + licenseKeyFormatting(s, k));
	}

	private static String licenseKeyFormatting(String s, int k) {
		int count = 0;
		int length = s.length();
		StringBuilder result = new StringBuilder();

		for(int i = length - 1; i >= 0; i--) {
			if (s.charAt(i) == '-') 
				continue;
			result.append(Character.toUpperCase(s.charAt(i)));
			count++;
			if (count == k) {
				result.append("-");
				count = 0;
			}
		}
		//Eliminate last character if it is dash
		if (result.length() > 0 && result.charAt(result.length() - 1) == '-')
			result = new StringBuilder(result.substring(0, result.length() - 1));

		//return reverse string    
		return result.reverse().toString();
	}

}
