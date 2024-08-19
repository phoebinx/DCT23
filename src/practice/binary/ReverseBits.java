package practice.binary;

public class ReverseBits {
	public static void main(String args[]) {
		ReverseBits obj = new ReverseBits();
		int n = 0b00000010100101000001111010011100;
		System.out.println(obj.reverseBits(n));
	}

	public int reverseBits(int n) {
		int res = 0;
		int bit = 0;
		for (int i = 0; i<32; i++) {
			//get ith bit of n
			bit = ((n >> i) & 1);
			res = (res | (bit << (31-i)));
 		}
		return res;
	}
}
