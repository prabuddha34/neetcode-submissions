public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair>> adj = new HashMap<>(); // Map a -> list of [b, a/b]

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            adj.putIfAbsent(a, new ArrayList<>());
            adj.putIfAbsent(b, new ArrayList<>());
            adj.get(a).add(new Pair(b, values[i]));
            adj.get(b).add(new Pair(a, 1 / values[i]));
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String target = queries.get(i).get(1);
            res[i] = dfs(src, target, adj, new HashSet<>());
        }

        return res;
    }

    private double dfs(String src, String target, Map<String, List<Pair>> adj, Set<String> visited) {
        if (!adj.containsKey(src) || !adj.containsKey(target)) {
            return -1.0;
        }
        if (src.equals(target)) {
            return 1.0;
        }

        visited.add(src);

        for (Pair neighbor : adj.get(src)) {
            if (!visited.contains(neighbor.node)) {
                double result = dfs(neighbor.node, target, adj, visited);
                if (result != -1.0) {
                    return neighbor.weight * result;
                }
            }
        }

        return -1.0;
    }

    class Pair {
        String node;
        double weight;

        Pair(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}