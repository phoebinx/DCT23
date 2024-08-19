package LinkedLists;

public class DetectCycle {
	public static void main(String args[]) {
		DetectCycle obj = new DetectCycle();
		//head = [3,2,0,-4], pos = 1
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = head.next;
		System.out.println(obj.hasCycle(head));
	}
	public boolean hasCycle(ListNode head) {
		if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(slow.next!= null && fast.next!=null && fast.next.next!=null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	if (slow == fast)
        		return true;
        }
        return false;
    }

}
