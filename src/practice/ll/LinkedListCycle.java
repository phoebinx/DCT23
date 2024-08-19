package practice.ll;

public class LinkedListCycle {
	public static void main(String args[]) {
		LinkedListCycle obj = new LinkedListCycle();
		ListNode head = obj.new ListNode(3);
		head.next = obj.new ListNode(2);
		head.next.next = obj.new ListNode(0);
		head.next.next.next = obj.new ListNode(-4);
		head.next.next.next.next = head.next;
		System.out.println(obj.hasCycle(head));
	}

	public boolean hasCycle(ListNode head) {
		if (head == null)
			return false;
		ListNode slow = head;
		ListNode fast = head;
		while (slow.next != null && fast.next !=null && fast.next.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) return true;
		}
		return false;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
