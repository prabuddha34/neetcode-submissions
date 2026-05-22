class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int s1Count[] = new int[26];
        int slidingWindow[] = new int[26];

        // Build frequency arrays
        for (int i = 0; i < s1.length(); i++) {

            s1Count[s1.charAt(i) - 'a']++;

            slidingWindow[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (matches(s1Count, slidingWindow)) {
            return true;
        }

        // Sliding window
        for (int i = s1.length(); i < s2.length(); i++) {

            // Add new char
            slidingWindow[s2.charAt(i) - 'a']++;

            // Remove old char
            slidingWindow[s2.charAt(i - s1.length()) - 'a']--;

            if (matches(s1Count, slidingWindow)) {
                return true;
            }
        }

        return false;
    }

    public boolean matches(int a[], int b[]) {

        for (int i = 0; i < 26; i++) {

            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}
