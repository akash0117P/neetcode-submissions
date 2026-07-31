class Solution {
    boolean isPalinedrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i <= j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
    void dfs(int index, String s, List<List<String>> res, List<String> ans) {
        if (index == s.length()) {
            res.add(new ArrayList<>(ans));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String temp = s.substring(index, i + 1);
            if (isPalinedrome(temp)) {
                ans.add(temp);
                dfs(i + 1, s, res, ans);
                ans.remove(ans.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        dfs(0, s, res, ans);
        return res;
    }
}
