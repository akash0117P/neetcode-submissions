class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        List<Integer> res = new ArrayList<>();

        int end = 0;
        int size = 0;

        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(lastIndex[s.charAt(i) - 'a'], end);

            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
