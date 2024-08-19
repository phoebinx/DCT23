package LinkedLists;

import java.util.PriorityQueue;

public class MergeKSortedLists {
	public static void main(String args[]) {
		MergeKSortedLists obj = new MergeKSortedLists();
		int arr[][] = { { 1, 4, 5 }, { 1, 3, 4 }, { 2, 6 } };
//		int arr[][] = {{}};
		ListNode lists[] = new ListNode[arr.length];
		for (int i = 0; i < arr.length; i++) {
			lists[i] = obj.populateList(arr[i]);
			ListNode temp = lists[i];
		}
		ListNode resList = obj.mergeKLists(lists);
		ListNode temp = resList;
		while (temp != null) {
			System.out.print(temp.val+ " ");
			temp = temp.next;
		}
		
	}

	private ListNode populateList(int arr[]) {
		ListNode head = new ListNode();
		ListNode temp = head;
		for (int i = 0; i < arr.length; i++) {
			temp.next = new ListNode(arr[i]);
			temp = temp.next;
		}
		return head.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<>((ListNode node1, ListNode node2) -> {
			return node1.val - node2.val;
		});
		ListNode resList = new ListNode();
		ListNode temp = resList;

		for (ListNode list : lists) {
			if (list != null)
				pq.offer(list);
		}

		while (!pq.isEmpty()) {
			ListNode node = pq.poll();
			if (node.next != null)
				pq.offer(node.next);
			temp.next = node;
			temp = temp.next;
		}
		return resList.next;
	}
}
