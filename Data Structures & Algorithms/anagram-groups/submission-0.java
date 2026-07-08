class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> mp = new HashMap<>();

        for(String str : strs)
        {
          int[] arr = new int[26];

          for(char chr : str.toCharArray()){
            arr[chr - 'a']++;
          }

           String key = Arrays.toString(arr);

            mp.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(mp.values());
    }
}
