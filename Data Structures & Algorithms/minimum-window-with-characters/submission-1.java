class Solution {
    public String minWindow(String s, String t) {
        int[] need = new int[128];

        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);

            if (need[r] > 0) {
                count--;
            }

            need[r]--;

            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char l = s.charAt(left);
                need[l]++;

                if (need[l] > 0) {
                    count++;
                }

                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + minLen);
    }
}
