package practice.ll;

public class ReverseLL {
	public static void main(String args[]) {
		ReverseLL obj = new ReverseLL();
		Integer arr[] = { 1, 2, 3, 4, 5 };
		ListNode head = obj.createLL(arr);
		ListNode rHead = obj.reverseList(head);
		obj.printLL(rHead);
	}

	public ListNode reverseList(ListNode head) {
		ListNode node = head;
		ListNode prev, temp;
		prev = null;
		while(node!= null) {
			temp = node.next;
			node.next = prev;
			prev = node;
			node = temp;
		}
		return prev;
	}

	private void printLL(ListNode head) {
		while (head != null) {
			System.out.print(head.val+ " ");
			head = head.next;
		}
	}

	private ListNode createLL(Integer arr[]) {
		ListNode head, node;
		head = new ListNode();
		node = head;
		for (Integer n : arr) {
			node.next = new ListNode(n);
			node = node.next;
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
