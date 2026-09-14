/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        Map<Node, Node> mp = new HashMap<>();
        Node cur = head;

        while (cur != null) {
            mp.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            Node copy = mp.get(cur);
            copy.next = mp.get(cur.next);
            copy.random = mp.get(cur.random);
            cur = cur.next;
        }
        return mp.get(head);
    }
}
