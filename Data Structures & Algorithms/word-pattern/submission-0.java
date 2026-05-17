public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, Integer> charToWord = new HashMap<>();
        Set<String> store = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            if (charToWord.containsKey(c)) {
                if (!words[charToWord.get(c)].equals(words[i])) {
                    return false;
                }
            } else {
                if (store.contains(words[i])) {
                    return false;
                }
                charToWord.put(c, i);
                store.add(words[i]);
            }
        }

        return true;
    }
}