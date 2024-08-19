package practice.binary;

public class SumOfTwoInts {
	public static void main(String args[]) {
		SumOfTwoInts obj = new SumOfTwoInts();
		int a = 2, b = 3;
		System.out.println(obj.getSum(a, b));
	}

	public int getSum(int a, int b) {
		int temp;
		while (b != 0) {
			temp = (a & b) << 1;
			a = a ^ b;
			b = temp;
		}
		return a;
	}
}
/*
 * The left shift by 1 is used to move the carry bits into the correct positions
 * so they can be added in the next iteration of the loop. This process mimics
 * the manual method of addition where carrying digits are shifted to the left
 * and added in the next higher place value.
 */