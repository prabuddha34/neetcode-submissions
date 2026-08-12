public class StockSpanner {
    private List<Integer> arr;

    public StockSpanner() {
        arr = new ArrayList<>();
    }

    public int next(int price) {
        arr.add(price);
        int i = arr.size() - 2;
        while (i >= 0 && arr.get(i) <= price) {
            i--;
        }
        return arr.size() - i - 1;
    }
}