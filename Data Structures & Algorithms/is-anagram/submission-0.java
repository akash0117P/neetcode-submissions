class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character,Integer> mp1 = new HashMap<>();

        for(char str : s.toCharArray()){
            mp1.put(str,mp1.getOrDefault(str, 0) + 1);
        }

        Map<Character,Integer> mp2 = new HashMap<>();

        for(char str : t.toCharArray()){
            mp2.put(str,mp2.getOrDefault(str, 0) + 1);
        }

        for(char str : mp1.keySet()){
            if(!mp1.get(str).equals(mp2.get(str))){
                return false;
            }
        }

        return true;

    }
}
