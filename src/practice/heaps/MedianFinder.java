package practice.heaps;

import java.util.PriorityQueue;

public class MedianFinder {
	PriorityQueue<Integer> maxPQ;
	PriorityQueue<Integer> minPQ;

	public static void main(String args[]) {
		MedianFinder obj = new MedianFinder();
		obj.addNum(1);
		obj.addNum(2);
		System.out.println(obj.findMedian());
		obj.addNum(3);
		System.out.println(obj.findMedian());
	}

	public MedianFinder() {
		maxPQ = new PriorityQueue<>((n1, n2) -> {
			return n2 - n1;
		});
		minPQ = new PriorityQueue<>((n1, n2) -> {
			return n1 - n2;
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
			return (minPQ.peek() + maxPQ.peek()) / 2.0;
		} else {
			return (double) maxPQ.peek();
		}

	}
}
