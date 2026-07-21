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
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode t1 = head.next;
        ListNode t2 = null;

        if (head.next != null) {
            t2 = head.next.next;
        }

        while (t1 != null && t2 != null) {
            if (t1.val == t2.val) {
                return true;
            }

            t1 = t1.next;

            if (t2.next != null) {
                t2 = t2.next.next;
            } else {
                t2 = null;
            }
        }
        return false;
    }
}
