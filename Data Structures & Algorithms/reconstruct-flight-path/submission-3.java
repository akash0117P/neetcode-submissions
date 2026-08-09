class Solution {
    Map<String, PriorityQueue<String>> adj;
    List<String> res;
    int n;

    void dfs(String src) {
        PriorityQueue<String> q = adj.get(src);
        while (q != null && !q.isEmpty()) {
            String v = q.poll();
            dfs(v);
        }
        res.add(src);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        n = tickets.size() + 1;
        res = new ArrayList<>();

        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.computeIfAbsent(src, k -> new PriorityQueue<>()).offer(dst);
        }

        dfs("JFK");
        Collections.reverse(res);

        return res;
    }
}
