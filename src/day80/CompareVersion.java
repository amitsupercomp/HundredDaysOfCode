package day80;

public class CompareVersion {
	
	public static void main(String[] args) {
		String version1 = "1.01", version2 = "1.001";
		System.out.println("Output :: " + compareVersion(version1, version2));
	}

	private static int compareVersion(String version1, String version2) {
		int n = version1.length(), m = version2.length();
		int i = 0, j = 0;
		while (i < n || j < m) {
			int x = 0;
			for (; i < n && version1.charAt(i) != '.'; ++i) {
				x = x * 10 + version1.charAt(i) - '0';
			}
			++i;
			int y = 0;
			for (; j < m && version2.charAt(j) != '.'; ++j) {
				y = y * 10 + version2.charAt(j) - '0';
			}
			++j;
			if (x != y) {
				return x > y ? 1 : -1;
			}
		}
		return 0;
	}

}
