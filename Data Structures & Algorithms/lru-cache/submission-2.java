class Node {
    int key;
    int val;
    Node next;
    Node prev;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
class LRUCache {
    Map<Integer, Node> mp;
    Node head;
    Node tail;
    int cap;

    public LRUCache(int capacity) {
        mp = new HashMap<>();
        this.cap = capacity;
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!mp.containsKey(key))
            return -1;
        Node res = mp.get(key);
        delete(res);
        insert(res);
        return res.val;
    }

    public void put(int key, int value) {
        if (mp.containsKey(key)) {
            Node res = mp.get(key);
            delete(res);
            res.val = value;
            insert(res);
        } else {
            if (mp.size() == cap) {
                Node temp = tail.prev;
                mp.remove(temp.key);
                delete(temp);
            }

            Node newNode = new Node(key, value);
            insert(newNode);
            mp.putIfAbsent(key, newNode);
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
        head.next = temp;
        temp.prev = head;
        right.prev = temp;
    }
}
