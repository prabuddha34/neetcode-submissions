public class Solution {
    private List<Integer>[] adj;
    private int[][] isPrereq;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adj = new ArrayList[numCourses];
        isPrereq = new int[numCourses][numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
            Arrays.fill(isPrereq[i], -1);
        }

        for (int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]);
            isPrereq[pre[1]][pre[0]] = 1;
        }

        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(dfs(query[1], query[0]));
        }
        return res;
    }

    private boolean dfs(int crs, int prereq) {
        if (isPrereq[crs][prereq] != -1) {
            return isPrereq[crs][prereq] == 1;
        }
        for (int pre : adj[crs]) {
            if (pre == prereq || dfs(pre, prereq)) {
                isPrereq[crs][prereq] = 1;
                return true;
            }
        }
        isPrereq[crs][prereq] = 0;
        return false;
    }
}