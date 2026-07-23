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
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }

    ListNode get(ListNode curr, int k) {
        k = k - 1;
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;

        while (true) {
            ListNode kthNode = get(temp, k);
            if (kthNode == null) {
                prevNode.next = temp;
                break;
            }
            ListNode nextnode = kthNode.next;
            kthNode.next = null;
            reverse(temp);

            if (head == temp) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }

            prevNode = temp;
            temp = nextnode;
        }
        return head;
    }
}
