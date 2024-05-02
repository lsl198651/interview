package leetCode;

import java.util.ArrayList;
import java.util.List;

public class lc21 {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    List<Integer> vals1 = new ArrayList<Integer>();
    List<Integer> vals2 = new ArrayList<Integer>();
    while(list1 != null){
	  vals1.add(list1.val);
	  list1 = list1.next;
	}
	while(list2 != null){
	  vals2.add(list2.val);
	  list2 = list2.next;
	}

	List<Integer> vals = new ArrayList<Integer>();
	vals.addAll(vals1);
	vals.addAll(vals2);
	vals.sort((v1, v2) -> v1 - v2);
	ListNode dummy = new ListNode(-1);
	ListNode head = dummy;
	for (int val : vals) {
	  head.next = new ListNode(val);
	  head = head.next;
	}
	return dummy.next;
}
}
