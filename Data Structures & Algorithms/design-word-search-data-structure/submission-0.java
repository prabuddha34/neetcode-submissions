class WordDictionary {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }

            curr = curr.child[idx];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int pos, TrieNode node) {
        if (node == null) {
            return false;
        }

        if (pos == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(pos);

        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (dfs(word, pos + 1, node.child[i])) {
                    return true;
                }
            }
            return false;
        }

        return dfs(word, pos + 1, node.child[ch - 'a']);
    }
}
