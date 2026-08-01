class Node {
    Node[] links = new Node[26];
    boolean fl;

    public Node() {}

    boolean containsKey(char ch) {
        if (links[ch - 'a'] == null) {
            return false;
        }
        return true;
    }
    void put(char ch, Node temp) {
        links[ch - 'a'] = temp;
        return;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }
    void setEnd() {
        fl = true;
    }
}

class PrefixTree {
    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.containsKey(word.charAt(i))) {
                curr.put(word.charAt(i), new Node());
            }
            curr = curr.get(word.charAt(i));
        }
        curr.setEnd();
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.containsKey(word.charAt(i))) {
                curr = curr.get(word.charAt(i));
            }
        }
        if (curr.fl == true)
            return true;

        return false;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (curr == null || !curr.containsKey(prefix.charAt(i))) {
                return false;
            }
            curr = curr.get(prefix.charAt(i));
        }
        return true;
    }
}
