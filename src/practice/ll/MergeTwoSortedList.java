package practice.ll;

public class MergeTwoSortedList {
	public static void main(String args[]) {
		MergeTwoSortedList obj = new MergeTwoSortedList();
		int [] arr1 = {1,2,4}; int arr2[] = {1,3,4};
		ListNode list1 = obj.buildLL(arr1);
		ListNode list2 = obj.buildLL(arr2);
		ListNode node = obj.mergeTwoLists(list1, list2);
		while(node != null) {
			System.out.print(node.val+" ");
			node = node.next;
		}
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null  && list2 == null) return null;
		if (list1 == null) return list2;
		if (list2 == null) return list1;
		ListNode list3 = new ListNode();
		ListNode node = list3;
		while (list1 !=null && list2 != null) {
			if (list1.val <= list2.val) {
				node.next = list1;
				list1 = list1.next;
			} else {
				node.next = list2;
				list2 = list2.next;
			}
			node = node.next;
		}
		
		while (list1 !=null) {
			node.next = list1;
			list1 = list1.next;
			node = node.next;
		}
		
		while (list2 !=null) {
			node.next = list2;
			list2 = list2.next;
			node = node.next;
		}
		return list3.next;
	}
	

	private ListNode buildLL (int arr[]) {
		ListNode head = new ListNode();
		ListNode node = head;
		for (int n:arr) {
			node.next = new ListNode(n);
			node = node.next;
		}
		return head.next;
	}
	static class ListNode {
		int val;
		ListNode next;
		ListNode(){
			
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
