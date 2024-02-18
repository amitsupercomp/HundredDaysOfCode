package day5;

public class LengthOfLastWord {

	public static void main(String[] args) {
		String s = "Amit";
		System.out.println("Length of last word :: " + lengthOfLastWord(s));
	}

	private static int lengthOfLastWord(String s) {
		
		//First check the string if it is null or empty it will return 0
		if(s == null || s.length() == 0)
			return 0;
		
		//Initialize variable of result and one flag.
		int result = 0;
		int len = s.length();
		boolean flag = false;
		
		//Start the loop from end and count the alphabet upto start of the word.
		for(int i=len-1; i>=0; i--){
			char c = s.charAt(i);
			
			//result will be increase by 1 till character will be alphabet.
			if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
				flag = true;
				result++;
			}else{
				if(flag)
					return result;
			}
		}
		return result;
	}
}
