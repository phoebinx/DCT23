package practice.ll;

public class RemoveNthNodeFromList {
	public static void main(String args[]) {
		RemoveNthNodeFromList obj = new RemoveNthNodeFromList();
		int[] arr = { 1, 2, 3, 4, 5 };
		ListNode head = obj.buildLL(arr);
		int n = 2;
		obj.removeNthFromEnd(head, n);
		obj.printLL(head);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) return null;
		ListNode leftPtr, rightPtr;
		leftPtr = head; rightPtr = head;
		//move rightPtr n distance from leftPtr
		int curPos = 0;
		while (curPos < n) {
			rightPtr = rightPtr.next;
			curPos++;
		}
		
		if (rightPtr == null) return head.next; //head is n away from the end of the list
		
		//move rightPtr to last node
		while (rightPtr.next != null) {
			rightPtr = rightPtr.next;
			leftPtr = leftPtr.next;
			
		}
		leftPtr.next = leftPtr.next.next;
		return head;
	}
	

	private ListNode buildLL(int[] arr) {
		if (arr.length == 0)
			return null;
		ListNode head = new ListNode(arr[0]);
		ListNode node = head;
		for (int i = 1; i < arr.length; i++) {
			ListNode temp = new ListNode(arr[i]);
			node.next = temp;
			node = temp;
		}
		return head;
	}

	private void printLL(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
}
