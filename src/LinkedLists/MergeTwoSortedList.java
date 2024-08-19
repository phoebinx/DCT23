package LinkedLists;

public class MergeTwoSortedList {
	public static void main(String args[]) {
		MergeTwoSortedList obj = new MergeTwoSortedList();
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(4);
		ListNode head2 = new ListNode(1);
		head2.next = new ListNode(3);
		head2.next.next = new ListNode(4);
		ListNode res = obj.mergeTwoLists(head1, head2);
		while (res != null) {
			System.out.print(res.val + " ");
			res = res.next;
		}
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null)
			return null;
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode list3 = new ListNode();
		ListNode temp = list3;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				temp.next = new ListNode(list1.val);
				list1 = list1.next;
			} else {
				temp.next = new ListNode(list2.val);
				list2 = list2.next;
			}
			temp = temp.next;
		}

		while (list1 != null) {
			temp.next = new ListNode(list1.val);
			temp = temp.next;
			list1 = list1.next;
		}

		while (list2 != null) {
			temp.next = new ListNode(list2.val);
			temp = temp.next;
			list2 = list2.next;
		}

		return list3.next;
	}
}
