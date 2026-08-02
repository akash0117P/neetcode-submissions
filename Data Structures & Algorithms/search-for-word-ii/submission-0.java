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

class Solution {
    Node root;
    int n;
    int m;
    boolean[][] visited;
    List<String> res;
    Set<String> st;

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
    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        n = board.length;
        m = board[0].length;
        res = new ArrayList<>();
        st = new HashSet<>();
        visited = new boolean[n][m];

        for (String word : words) {
            insert(word);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(i, j, board, "", root);
            }
        }

        for (String str : st) {
            res.add(str);
        }
        return res;
    }

    void dfs(int i, int j, char[][] board, String word, Node curr) {
        if (curr.fl == true) {
            st.add(word);
        }
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || !curr.containsKey(board[i][j])) {
            return;
        }

        visited[i][j] = true;
        curr = curr.get(board[i][j]);
        word = word + board[i][j];

        dfs(i + 1, j, board, word, curr);
        dfs(i - 1, j, board, word, curr);
        dfs(i, j + 1, board, word, curr);
        dfs(i, j - 1, board, word, curr);

        visited[i][j] = false;
    }
}
