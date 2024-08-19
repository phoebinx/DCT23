package practice.dp;

public class LongestCommonSubseq {
	public static void main(String args[]) {
		LongestCommonSubseq obj = new LongestCommonSubseq();
		String text1 = "abcde";
		String text2 = "ace";
		System.out.println(obj.longestCommonSubsequence(text1, text2));
	}

	public int longestCommonSubsequence(String text1, String text2) {
		int grid[][] = new int [text1.length()+1][text2.length()+1];
		for (int i = text1.length()-1; i>=0; i--) {
			for (int j = text2.length()-1; j>=0; j--) {
				if (text1.charAt(i) == text2.charAt(j)) 
					grid[i][j] = grid[i+1][j+1]+1;
				else 
					grid[i][j] = Math.max(grid[i+1][j], grid[i][j+1]);
			}
		}
		return grid[0][0];
	}

}
