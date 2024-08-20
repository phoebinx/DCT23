package interviews.intuit;

public class MaxScore {
	public static void main(String args[]) {
		MaxScore obj = new MaxScore();
		int[] nums1 = { 2, 4, 5, 8, 10 }, nums2 = { 4, 6, 8, 9 };
		System.out.println(obj.maxSum(nums1, nums2));
	}

	public int maxSum(int[] nums1, int[] nums2) {
		// tracks running sum of both arrays
		long sum1 = 0, sum2 = 0;
		int n1 = nums1.length, n2 = nums2.length;
		int i = 0, j = 0;
		long sum = 0L;
		long mod = 100007L;
		while (i < n1 && j < n2) {
			// allow the smaller element array to catch up so they can meet at common
			// element
			if (nums1[i] < nums2[j]) {
				sum1 += nums1[i];
				i++;
			} else if (nums2[j] < nums1[i]) {
				sum2 += nums2[j];
				j++;
			} else if (nums1[i] == nums2[j]) {
				sum += nums1[i] + Math.max(sum1, sum2);
				i++;
				j++;
				sum1 = sum2 = 0;
			}
		}
		// Add remaining elements in nums1 (if any)
		while (i < n1) {
			sum1 += nums1[i];
			i++;
		}

		// Add remaining elements in nums2 (if any)
		while (j < n2) {
			sum2 += nums2[j];
			j++;
		}

		// Add the maximum of the remaining sums to the total sum
		sum = (long) ((sum + Math.max(sum1, sum2)) % mod);

		return (int) sum;
	}
}
