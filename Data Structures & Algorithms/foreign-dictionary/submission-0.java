class Solution {
    List<List<Integer>> adj;
    boolean[] exists;
    List<Integer> topoSort() {
        int[] inDegree = new int[26];

        for (int i = 0; i < 26; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            if (exists[i] && inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int it : adj.get(node)) {
                inDegree[it]--;

                if (inDegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        return res;
    }
    public String foreignDictionary(String[] words) {
        adj = new ArrayList<>();
        boolean foundDifference = false;

        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        exists = new boolean[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                exists[c - 'a'] = true;
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int min = Math.min(s1.length(), s2.length());

            for (int ptr = 0; ptr < min; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    int u = s1.charAt(ptr) - 'a';
                    int v = s2.charAt(ptr) - 'a';
                    adj.get(u).add(v);
                    foundDifference = true;
                    break;
                }
            }

            if (!foundDifference && s1.length() > s2.length()) {
                return "";
            }
        }

        List<Integer> ans = topoSort();
        int count =0;

        for (int i = 0; i < 26; i++) {
            if (exists[i]) {
                count++;
            }
        }

        // Cycle detected
        if (ans.size() != count) {
            return "";
        }

        String str = "";

        for (int i : ans) {
            str = str + (char) (i + 'a');
        }
        return str;
    }
}
