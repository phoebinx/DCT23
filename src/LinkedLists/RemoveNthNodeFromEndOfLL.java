package LinkedLists;

public class RemoveNthNodeFromEndOfLL {
	public static void main(String args[]) {
		RemoveNthNodeFromEndOfLL obj = new RemoveNthNodeFromEndOfLL();
		int arr [] = {1};
		ListNode head = obj.populateList(arr);
		int n = 1;
		ListNode res = obj.removeNthFromEnd(head, n);
		ListNode temp = res;
		while (temp!=null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) return null;
		ListNode nodeLeft = head, nodeRight = head, prev = null;
		//point noderight to n and then start nodeleft so when node noderight reaches end, nodeleft on the item that needs to be deleted
		int curPos = 0;
		while (curPos < n) {
			nodeRight = nodeRight.next;
			curPos++;
		}
		
		if (nodeRight == null) {
			return head.next;  //current nodeLeft is to be deleted which is head.next			
		}
		 
		while (nodeRight != null) {
			prev = nodeLeft;
			nodeLeft= nodeLeft.next;
			nodeRight = nodeRight.next;
		}
		
		prev.next = nodeLeft.next;
		return head;
				
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
