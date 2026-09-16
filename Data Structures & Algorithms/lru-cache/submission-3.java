class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    Map<Integer, Node> mp;
    int cap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        mp = new HashMap<>();
        this.cap = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        }
        Node temp = mp.get(key);
        delete(temp);
        insert(temp);
        return temp.val;
    }

    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            Node temp = mp.get(key);
            delete(temp);
            temp.val = value;
            insert(temp);
        } else {
            if (mp.size() == cap) {
                Node temp = tail.prev;
                mp.remove(temp.key);
                delete(temp);
            }
            Node cur = new Node(key, value);
            insert(cur);
            mp.putIfAbsent(key, cur);
        }
    }

    void delete(Node temp) {
        Node left = temp.prev;
        Node right = temp.next;

        left.next = right;
        right.prev = left;
        temp.prev = null;
        temp.next = null;
    }

    void insert(Node temp) {
        Node right = head.next;

        temp.next = right;
        temp.prev = head;
        head.next = temp;
        right.prev = temp;
    }
}
