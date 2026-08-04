class Solution {
    List<List<Integer>> adj;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                inDegree[it]++;
            }
        }

        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            res.add(node);

            for (int i : adj.get(node)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.offer(i);
                }
            }
        }

        return res.size() == numCourses;
    }
}
