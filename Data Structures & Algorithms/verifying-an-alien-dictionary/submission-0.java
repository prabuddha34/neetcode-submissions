class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        int[] rank = new int[26];

        for (int i = 0; i < order.length(); i++) {
            rank[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {

            String w1 = words[i];
            String w2 = words[i + 1];

            if (!inOrder(w1, w2, rank)) {
                return false;
            }
        }

        return true;
    }

    private boolean inOrder(String a, String b, int[] rank) {

        int len = Math.min(a.length(), b.length());

        for (int i = 0; i < len; i++) {

            char c1 = a.charAt(i);
            char c2 = b.charAt(i);

            if (c1 != c2) {
                return rank[c1 - 'a'] < rank[c2 - 'a'];
            }
        }

        return a.length() <= b.length();
    }
}