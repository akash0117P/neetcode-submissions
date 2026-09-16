/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        }

        if (l2 != null) {
            temp.next = l2;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        ListNode temp = lists[0];

        for (int i = 1; i < lists.length; i++) {
            temp = merge(temp, lists[i]);
        }
        return temp;
    }
}
