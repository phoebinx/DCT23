package interviews.amazon;

//LinkedList
public class AddTwoNumbers {
	public static void main(String args[]) {
		AddTwoNumbers obj = new AddTwoNumbers();
		int arr1[] = { 2, 4, 3 }, arr2[] = { 5, 6, 4 };
		ListNode l1 = obj.buildLL(arr1);
		ListNode l2 = obj.buildLL(arr2);
		ListNode l3 = obj.addTwoNumbers(l1, l2);
		obj.printLL(l3);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode temp = dummyHead;
		int carry = 0;

		// Traverse both lists
		while (l1 != null || l2 != null) {
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			int curSum = x + y + carry;

			// Update carry for next iteration
			carry = curSum / 10;

			// Create new node with current digit
			temp.next = new ListNode(curSum % 10);
			temp = temp.next;

			// Move to the next nodes in the lists
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}

		// If there's still carry left, add it
		if (carry > 0) {
			temp.next = new ListNode(carry);
		}

		return dummyHead.next; // Return the next of dummy node
	}

	private void printLL(ListNode l) {
		while (l != null) {
			System.out.print(l.val + " ");
			l = l.next;
		}
		System.out.println();
	}

	private ListNode buildLL(int[] arr) {
		ListNode head = new ListNode();
		ListNode temp = head;
		for (int n : arr) {
			temp.next = new ListNode(n);
			temp = temp.next;
		}
		return head.next;
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
