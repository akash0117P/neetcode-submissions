class Node {
    Node[] links = new Node[26];
    boolean fl;

    Node() {}

    void put(Node temp, char ch) {
        links[ch - 'a'] = temp;
    }

    boolean containsKey(char ch) {
        if (links[ch - 'a'] == null) {
            return false;
        }
        return true;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }
    void setEnd() {
        fl = true;
    }
}

class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.containsKey(word.charAt(i))) {
                curr.put(new Node(), word.charAt(i));
            }
            curr = curr.get(word.charAt(i));
        }

        curr.setEnd();
    }

    public boolean search(String word) {
        return searchwithDot(0, word, root);
    }

    boolean searchwithDot(int index, String word, Node curr) {
        if (index == word.length()) {
            return curr.fl;
        }

        if (word.charAt(index) == '.') {
            for (int j = 0; j < 26; j++) {
                Node child = curr.get((char) ('a' + j));
                if (child != null && searchwithDot(index + 1, word, child)) {
                    return true;
                }
            }
            return false;
        }

        if (!curr.containsKey(word.charAt(index))) {
            return false;
        }
        curr = curr.get(word.charAt(index));

        return searchwithDot(index + 1, word, curr);
    }
}
