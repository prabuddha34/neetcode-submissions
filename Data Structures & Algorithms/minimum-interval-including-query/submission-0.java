public class Solution {
   public int[] minInterval(int[][] intervals, int[] queries) {
       List<int[]> events = new ArrayList<>();
       for (int i = 0; i < intervals.length; i++) {
           events.add(new int[]{intervals[i][0], 0, intervals[i][1] - intervals[i][0] + 1, i});
           events.add(new int[]{intervals[i][1], 2, intervals[i][1] - intervals[i][0] + 1, i});
       }

       for (int i = 0; i < queries.length; i++) {
           events.add(new int[]{queries[i], 1, i});
       }

       // Sort by time and type (end before query)
       events.sort((a, b) -> a[0] != b[0] ?
                  Integer.compare(a[0], b[0]) :
                  Integer.compare(a[1], b[1]));

       int[] ans = new int[queries.length];
       Arrays.fill(ans, -1);

       // Min heap storing [size, index]
       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
       boolean[] inactive = new boolean[intervals.length];

       for (int[] event : events) {
           if (event[1] == 0) { // Interval start
               pq.offer(new int[]{event[2], event[3]});
           }
           else if (event[1] == 2) { // Interval end
               inactive[event[3]] = true;
           }
           else { // Query
               while (!pq.isEmpty() && inactive[pq.peek()[1]]) {
                   pq.poll();
               }
               if (!pq.isEmpty()) {
                   ans[event[2]] = pq.peek()[0];
               }
           }
       }

       return ans;
   }
}