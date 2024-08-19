package practice.binary;

public class NoOfSetBits {
	public static void main(String args[]) {
		NoOfSetBits obj = new NoOfSetBits();
		int n = 128;
		System.out.println(obj.hammingWeight(n));
	}

	public int hammingWeight(int n) {
		// calculate binary equivalent
		// number of set bits?
		int noOfSetBits = 0;
		while (n != 0) {
			if (n%2 == 1) noOfSetBits++;
			n = n>>1;
		}
		return noOfSetBits;
	}
}
