package day38;

public class PalindromeNumber {
	
	public static void main(String[] args) {
		int a = 12121;
		System.out.println("Is Palindrome :: " + isPalindrome(a));
	}
	
	private static boolean isPalindrome(int x) 
    {
        int numCheck = 0, check = x;
        if(x>=0)
        {
        while(x != 0)
        {
            numCheck = numCheck * 10 + (x % 10);
            x /= 10;
        }
        if(check == numCheck)
        return true;
        return false;
        }
       else
        return false;
    }

}
