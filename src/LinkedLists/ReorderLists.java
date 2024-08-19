package LinkedLists;

public class ReorderLists {

	public static void main(String args[]) {
		ReorderLists obj = new ReorderLists();
		int arr[] = { 1, 2, 3, 4 };
		ListNode head = obj.populateList(arr);
		obj.reorderList(head);
		ListNode temp = head;
		System.out.println();
		while (temp!=null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
	}

	public void reorderList(ListNode head) {
		ListNode head2 = findSecondListHead(head);
		ListNode temp = head2;
		head2 = head2.next;
		temp.next = null;
		
		head2 = reverseLL(head2);
		printList(head2);
		//merge the two 
		ListNode temp1, temp2;
		
		while (head2 != null) {
			temp1 = head.next;
			temp2 = head2.next;
			head.next = head2;
			head2.next = temp1;
			head = temp1;
			head2 = temp2;
		}	
	}
	
	private ListNode findSecondListHead(ListNode head) {
		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	private ListNode reverseLL(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
	private void printList(ListNode head) {
		ListNode temp = head;
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
}
