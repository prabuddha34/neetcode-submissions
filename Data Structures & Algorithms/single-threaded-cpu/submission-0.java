public class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) ->
            a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0])
        );
        PriorityQueue<int[]> pending = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int n = tasks.length;
        for (int i = 0; i < n; i++) {
            pending.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }

        long time = 0;
        int idx = 0;
        int[] res = new int[n];
        while (!pending.isEmpty() || !available.isEmpty()) {
            while (!pending.isEmpty() && pending.peek()[0] <= time) {
                int[] task = pending.poll();
                available.offer(new int[]{task[1], task[2]});
            }

            if (available.isEmpty()) {
                time = pending.peek()[0];
                continue;
            }

            int[] task = available.poll();
            time += task[0];
            res[idx++] = task[1];
        }

        return res;
    }
}