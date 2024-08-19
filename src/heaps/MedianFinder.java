package heaps;

import java.util.Map;
import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> maxPQ;
	PriorityQueue<Integer> minPQ;

	public static void main(String args[]) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1);    // arr = [1]
		medianFinder.addNum(2);    // arr = [1, 2]
		System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
		medianFinder.addNum(3);    // arr[1, 2, 3]
		System.out.println(medianFinder.findMedian());

	}

	public MedianFinder() {
		maxPQ = new PriorityQueue<>((n1, n2) -> {
			return (n2 - n1);
		});

		minPQ = new PriorityQueue<>((n1, n2) -> {
			return (n1 - n2);
		});
	}

	public void addNum(int num) {
		maxPQ.offer(num);
		minPQ.offer(maxPQ.poll());
		if (maxPQ.size() < minPQ.size()) {
			maxPQ.offer(minPQ.poll());
		}
	}

	public double findMedian() {
		if (maxPQ.size() == minPQ.size()) {
			return (maxPQ.peek() + minPQ.peek()) / 2.0;
		} else {
			return (double) maxPQ.peek();
		}

	}
}
