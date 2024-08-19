package interviews.intuit;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
	ListNode head, tail;
	int capacity;
	HashMap<Integer, ListNode> cacheMap;

	public static void main(String args[]) {
		int capacity = 2;
		LRUCache lRUCache = new LRUCache(capacity);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.get(1)); // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache.get(2)); // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache.get(1)); // return -1 (not found)
		System.out.println(lRUCache.get(3)); // return 3
		System.out.println(lRUCache.get(4)); // return 4

	}

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cacheMap = new HashMap<>();
		head = new ListNode();
		tail = new ListNode();
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		if (cacheMap.containsKey(key)) {
			ListNode res = cacheMap.get(key);
			removeLL(res);
			addFirstInLL(res);
			return res.val;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (cacheMap.containsKey(key)) {
			ListNode node = cacheMap.get(key);
			node.val = value;
			removeLL(cacheMap.get(key));
			addFirstInLL(node);
		} else {
			if (cacheMap.size() >= capacity) {
				removeLRU();
			}
			ListNode newNode = new ListNode(key, value);
			cacheMap.put(key, newNode);
			addFirstInLL(newNode);
		}
	}

	private void removeLL(ListNode node) {
		if (node.prev != null) {
			node.prev.next = node.next;
		}
		if (node.next != null) {
			node.next.prev = node.prev;
		}
	}

	private void addFirstInLL(ListNode node) {
		ListNode headNext = head.next;
		head.next = node;
		node.prev = head;
		node.next = headNext;
		headNext.prev = node;
	}

	private void removeLRU() {
		cacheMap.remove(tail.prev.key);
		removeLL(tail.prev);
	}

	static class ListNode {
		int key;
		int val;
		ListNode next, prev;

		ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}

		ListNode() {

		}
	}
}
