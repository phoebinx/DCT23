package practice.ll;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	public static void main(String args[]) {
		MergeKSortedLists obj = new MergeKSortedLists();
		int[][] arr = { { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } };
		ListNode[] lists = generateLists(arr);
		ListNode list = obj.mergeKLists(lists);
		obj.printLL(new ListNode[] { list });
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode res = new ListNode();
		ListNode temp = res;
		
		PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> {
			return l1.val - l2.val;
		});
		for (ListNode list : lists) {
			if (list != null )
				pq.offer(list);
		}
		
		while (!pq.isEmpty()) {
			temp.next = pq.poll();
			temp = temp.next;
			if (temp.next != null) {
				pq.offer(temp.next);
			}
		}
		return res.next;
	}

	private void printLL(ListNode[] lists) {
		for (ListNode list : lists) {
			ListNode temp = list;
			while (temp != null) {
				System.out.print(temp.val + " ");
				temp = temp.next;
			}
			System.out.println();
		}
	}

	private static ListNode[] generateLists(int[][] arr) {
		ListNode[] lists = new ListNode[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length > 0) {
				ListNode node = new ListNode(arr[i][0]);
				lists[i] = node;
				for (int j = 1; j < arr[i].length; j++) {
					node.next = new ListNode(arr[i][j]);
					node = node.next;
				}
			}
		}
		return lists;
	}

	static class ListNode {
		int val;
		ListNode next;
		ListNode() {
			
		}
		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
