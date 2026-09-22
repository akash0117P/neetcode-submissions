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
    ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
    ListNode findKthNode(ListNode head, int k) {
        ListNode temp = head;
        while (temp != null && --k > 0) {
            temp = temp.next;
        }
        return temp;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prevNode = null;
        ListNode temp = head;

        while (true) {
            ListNode kthNode = findKthNode(temp, k);

            if (kthNode == null) {
                prevNode.next = temp;
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            reverse(temp);

            if (head == temp) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }
            prevNode = temp;
            temp = nextNode;
        }
        return head;
    }
}
