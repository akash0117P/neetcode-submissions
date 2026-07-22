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
    void insert(Node head) {
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }
    }

    void pointRandom(Node head) {
        Node temp = head;

        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }else{
                temp.next.random = null;
            }
            temp = temp.next.next;
        }
    }

    Node getCopy(Node head) {
        Node dummy = new Node(0);
        Node temp = head;
        Node res = dummy;

        while (temp != null) {
            dummy.next = temp.next;
            dummy = dummy.next;

            temp.next = temp.next.next;
            temp = temp.next;

            if(temp != null){
                dummy.next = temp.next;
            }
            
        }
        return res.next;
    }
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        insert(head);
        pointRandom(head);
        return getCopy(head);
    }
}
