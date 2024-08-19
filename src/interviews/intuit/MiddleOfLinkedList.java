package interviews.intuit;

public class MiddleOfLinkedList {
	public static void main(String[] args) {
		MiddleOfLinkedList solution = new MiddleOfLinkedList();

		// Example 1
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);
		ListNode middle1 = solution.middleNode(head1);
		printListFromNode(middle1); // Output: 3 -> 4 -> 5

		// Example 2
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(3);
		head2.next.next.next = new ListNode(4);
		head2.next.next.next.next = new ListNode(5);
		head2.next.next.next.next.next = new ListNode(6);
		ListNode middle2 = solution.middleNode(head2);
		printListFromNode(middle2); // Output: 4 -> 5 -> 6
	}

	public ListNode middleNode(ListNode head) {
		ListNode slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	// Helper function to print list from a given node
	private static void printListFromNode(ListNode node) {
		while (node != null) {
			System.out.print(node.val);
			if (node.next != null) {
				System.out.print(" -> ");
			}
			node = node.next;
		}
		System.out.println();
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
			this.next = null;
		}
	}
}
