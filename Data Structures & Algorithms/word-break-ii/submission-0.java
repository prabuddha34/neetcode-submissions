class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
}

class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
}

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.addWord(word);
        }

        List<String> res = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), trie, res);
        return res;
    }

    private void backtrack(int index, String s, List<String> path, Trie trie, List<String> res) {
        if (index == s.length()) {
            res.add(String.join(" ", path));
            return;
        }

        TrieNode node = trie.root;
        StringBuilder word = new StringBuilder();
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!node.children.containsKey(c)) {
                break;
            }

            word.append(c);
            node = node.children.get(c);

            if (node.isWord) {
                path.add(word.toString());
                backtrack(i + 1, s, path, trie, res);
                path.remove(path.size() - 1);
            }
        }
    }
}