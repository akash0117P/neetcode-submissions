class Solution {
    Map<Character, String> mp;
    void dfs(int i, String digits, String ans, List<String> res) {
        if (i >= digits.length()) {
            res.add(ans);
            return;
        }
        String temp = mp.get(digits.charAt(i));
        for (char ch : temp.toCharArray()) {
            ans = ans + ch;
            dfs(i + 1, digits, ans, res);
            ans = ans.substring(0, ans.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        mp = new HashMap<>();
        List<String> res = new ArrayList<>();
        if (digits.equals("")) {
            return res;
        }
        String ans = "";
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        dfs(0, digits, ans, res);
        return res;
    }
}
