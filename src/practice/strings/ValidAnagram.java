package practice.strings;

public class ValidAnagram {
	public static void main(String args[]) {
		ValidAnagram obj = new ValidAnagram();
		String s = "anagram", t = "nagaram";
		System.out.println(obj.isAnagram(s, t));
	}

	public boolean isAnagram(String s, String t) {
		if (s == null && t == null)
			return true;
		if (s == null || t == null || s.length() != t.length())
			return false;

		int arr[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i) - 'a'] += 1;
			arr[t.charAt(i) - 'a'] -= 1;
		}

		for (int i : arr) {
			if (i != 0)
				return false;
		}

		return true;
	}

}
