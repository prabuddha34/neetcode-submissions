class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        // Pacific: top row + left column
        for (int i = 0; i < m; i++) {
            q.offer(new int[]{i, 0});
            pacific[i][0] = true;
        }

        for (int j = 0; j < n; j++) {
            q.offer(new int[]{0, j});
            pacific[0][j] = true;
        }

        bfs(heights, q, pacific);

        // Atlantic: bottom row + right column
        q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            q.offer(new int[]{i, n - 1});
            atlantic[i][n - 1] = true;
        }

        for (int j = 0; j < n; j++) {
            q.offer(new int[]{m - 1, j});
            atlantic[m - 1][j] = true;
        }

        bfs(heights, q, atlantic);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void bfs(int[][] heights, Queue<int[]> q, boolean[][] visited) {
        int m = heights.length;
        int n = heights[0].length;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (heights[nx][ny] < heights[x][y]) {
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}