class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> mp = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        int end = 0;
        int size = 0;

        for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(mp.get(s.charAt(i)), end);

            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
