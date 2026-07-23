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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode node : lists) {
            pq.add(node);
        }

        ListNode temp = new ListNode(0);
        ListNode head = temp;

        while (pq.size() != 0) {
            ListNode node = pq.peek();
            pq.remove();

            temp.next = node;
            temp = temp.next;

            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return head.next;
    }
}
