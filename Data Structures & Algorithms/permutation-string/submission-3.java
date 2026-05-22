class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int s1Count[] = new int[26];
        int windowCount[] = new int[26];

        // Count frequencies
        for (int i = 0; i < s1.length(); i++) {

            s1Count[s1.charAt(i) - 'a']++;

            windowCount[s2.charAt(i) - 'a']++;
        }

        // Check first window
        if (matches(s1Count, windowCount)) {
            return true;
        }

        // Sliding window
        for (int i = s1.length(); i < s2.length(); i++) {

            // Add new character
            windowCount[s2.charAt(i) - 'a']++;

            // Remove old character
            windowCount[s2.charAt(i - s1.length()) - 'a']--;

            if (matches(s1Count, windowCount)) {
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