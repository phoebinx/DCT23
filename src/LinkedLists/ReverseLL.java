package LinkedLists;

import java.util.LinkedList;

public class ReverseLL {
	public static void main(String args[]) {
		ReverseLL obj = new ReverseLL();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		obj.printLL(obj.reverseList(head));
	}

	
	public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = null;
        while ( curr != null) {
        	temp = curr.next;
        	curr.next = prev;
        	prev = curr;
        	curr = temp;        	
        		
        }
        return prev;
    }
	
	private void printLL(ListNode head) {
		ListNode temp = head;
		while(temp!=null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
}
