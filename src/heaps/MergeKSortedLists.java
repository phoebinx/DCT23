package heaps;

import java.util.PriorityQueue;


public class MergeKSortedLists {
	public static void main(String args[]) {
		MergeKSortedLists obj = new MergeKSortedLists();
		ListNode[] lists = obj.populateLL();
		ListNode res = obj.mergeKLists(lists);
		
		obj.printLL(res);
		
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode res = new ListNode(Integer.MIN_VALUE);
		ListNode curr = res;
		PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> {
			return n1.val - n2.val;
		});

		// fill pq with first element of every list
		for (ListNode node : lists) {
			if (node != null) {
				pq.offer(node);
			}
		}

		while (!pq.isEmpty()) {
			curr.next = pq.poll();
			curr = curr.next;
			if (curr.next != null) {
				pq.offer(curr.next);
			}
		}
		return res.next;
	}

	private ListNode[] populateLL() {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		ListNode[] lists = new ListNode[] { l1, l2, l3 };
		return lists;
	}

	private void printLL(ListNode res) {
		while (res != null) {
			System.out.print(res.val+" ");
			res = res.next;
		}
	}

	class ListNode {
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
