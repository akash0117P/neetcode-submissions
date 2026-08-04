class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
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

        int[] ans = new int[numCourses];
        int i = 0;
        for (int it : res) {
            ans[i] = it;
            i++;
        }

       if(res.size()!=numCourses){
        return new int[0];
       }

        return ans;
    }
}
