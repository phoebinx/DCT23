package interviews.intuit;

public class ExcelSheetColNo {
	public static void main(String args[]) {
		ExcelSheetColNo obj = new ExcelSheetColNo();
		String columnTitle = "AB";
		System.out.println(obj.titleToNumber(columnTitle));
	}

	public int titleToNumber(String columnTitle) {
		if (columnTitle == null || columnTitle.length() == 0) {
	        return 0;
	    }
	    
	    int columnNumber = 0;
	    int multiplier = 1;
	    
	    // Iterate from the last character to the first (right to left)
	    for (int i = columnTitle.length() - 1; i >= 0; i--) {
	        char currentChar = columnTitle.charAt(i);
	        int currentValue = currentChar - 'A' + 1;
	        columnNumber += currentValue * multiplier;
	        multiplier *= 26;
	    }
	    
	    return columnNumber;
	}
	
	
	public int titleToNumder2(String str) {
		if (str == null || str.length()== 0) return 0;
		int res =0 ;
		
		for (char c : str.toLowerCase().toCharArray()) {
			//as you add another char, you must account for the new shift by multiply res with base 
			res += res*26 + c-'A'+1;
		}
		return res;
	}

}
