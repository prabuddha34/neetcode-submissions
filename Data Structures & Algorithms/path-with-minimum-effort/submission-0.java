public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{0, 0, 0}); // {diff, row, col}

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int diff = curr[0], r = curr[1], c = curr[2];

            if (r == rows - 1 && c == cols - 1) return diff;
            if (dist[r][c] < diff) continue;

            for (int[] dir : directions) {
                int newR = r + dir[0], newC = c + dir[1];
                if (newR < 0 || newC < 0 || newR >= rows || newC >= cols) {
                    continue;
                }

                int newDiff = Math.max(diff, Math.abs(heights[r][c] - heights[newR][newC]));
                if (newDiff < dist[newR][newC]) {
                    dist[newR][newC] = newDiff;
                    minHeap.offer(new int[]{newDiff, newR, newC});
                }
            }
        }

        return 0;
    }
}