class TimeMap {
    Map<String, List<Pair<String, Integer>>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (mp.containsKey(key)) {
            mp.get(key).add(new Pair<>(value, timestamp));
        } else {
            mp.computeIfAbsent(key, k -> new ArrayList<>());
            mp.get(key).add(new Pair<>(value, timestamp));
        }
    }

    public String get(String key, int timestamp) {
        String res = "";

        if(!mp.containsKey(key))
        {
            return "";
        }
        List<Pair<String, Integer>> arr = mp.get(key);

        int l = 0;
        int r = arr.size() - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (timestamp >= arr.get(mid).getValue()) {
                res = arr.get(mid).getKey();
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }
}
