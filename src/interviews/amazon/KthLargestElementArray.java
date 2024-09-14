package interviews.amazon;

import java.util.PriorityQueue;

public class KthLargestElementArray {
	public static void main(String args[]) {
		KthLargestElementArray obj = new KthLargestElementArray();
		int[] nums = { 3, 2, 1, 5, 6, 4 };
		int k = 2;
		System.out.println(obj.findKthLargest(nums, k));
	}

	public int findKthLargest(int[] nums, int k) {
		// Min-heap with size k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        
        // Iterate through the array and add elements to the heap
        for (int num : nums) {
            minHeap.offer(num);
            // If heap size exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the heap is the kth largest element
        return minHeap.peek();
	}
}
