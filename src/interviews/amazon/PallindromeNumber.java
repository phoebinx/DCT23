package interviews.amazon;

//https://leetcode.com/problems/palindrome-number
public class PallindromeNumber {
	public static void main(String args[]) {
		PallindromeNumber obj = new PallindromeNumber();
		int x = 121;
		System.out.println(obj.isPalindrome(x));
	}

	public boolean isPalindrome(int x) {
		String str = Integer.toString(x);
		int start = 0, end = str.length()-1;
		while (start<=end) {
			if (str.charAt(start) != str.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}

}
