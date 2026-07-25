public class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>());
        return res;
    }

    private void backtrack(int i, int n, int k, List<Integer> comb) {
        if (i > n) {
            if (comb.size() == k) {
                res.add(new ArrayList<>(comb));
            }
            return;
        }

        comb.add(i);
        backtrack(i + 1, n, k, comb);
        comb.remove(comb.size() - 1);
        backtrack(i + 1, n, k, comb);
    }
}