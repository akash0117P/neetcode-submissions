class Solution {
    List<List<Integer>> adj;
    boolean fl ;
    boolean dfs(int i, int[] visit, int[] pathVisit) {
        visit[i] = 1;
        pathVisit[i] = 1;

        for (int adjNode : adj.get(i)) {
            if (visit[adjNode] != 1) {
                if (dfs(adjNode, visit, pathVisit)) {
                    return true;
                }
            } else {
                if (pathVisit[adjNode] == 1) {
                    return true;
                }
            }
        }
        pathVisit[i] = 0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        int[] visit = new int[numCourses];
        int[] pathVisit = new int[numCourses];


        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            adj.get(edge[0]).add(edge[1]);
        }

        for (int i = 0 ; i<numCourses; i++) {
			if (visit[i] != 1) {
				if (dfs(i, visit, pathVisit)) {
					fl= true;
				}
			}
		}

        if(fl){
            return false;
        }

        return true;
    }
}
