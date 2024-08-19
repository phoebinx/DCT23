package practice.ll;

public class ReorderList {

	public static void main(String args[]) {
		ReorderList obj = new ReorderList();
		ListNode head = obj.new ListNode(1);
		head.next = obj.new ListNode(2);
		head.next.next = obj.new ListNode(3);
		head.next.next.next = obj.new ListNode(4);
		head.next.next.next.next = obj.new ListNode(5);
		obj.reorderList(head);
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;
		// Find the node before the middle
		ListNode nodeBeforeMid = nodeBeforeMid(head);
		// Reverse the second half
		ListNode reversedList = reverseList(nodeBeforeMid.next);
		this.printLL(reversedList);
		nodeBeforeMid.next = null; // Cut off the first half

		// Merge the two halves
		ListNode first = head;
		ListNode second = reversedList;
		ListNode temp1 = null, temp2 = null;

		while (second != null) {
			temp1 = first.next;
			temp2 = second.next;
			first.next = second;
			second.next = temp1;
			first = temp1;
			second = temp2;
		}
		printLL(head);
	}

	private ListNode nodeBeforeMid(ListNode head) {
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode node = head;
		while (node != null) {
			ListNode temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
		}
		return prev;
	}

	private void printLL(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
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
