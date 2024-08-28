package Step5.Lec1;

class Trie {
    Trie[] children;
    boolean isEndOfWord;
    int count;

    public Trie() {
        children = new Trie[26];
        isEndOfWord = false;
        count = 0;
    }

    public void insert(String word) {
        Trie trie = this;
        for (char c : word.toCharArray()) {
            if (trie.children[c - 'a'] == null) {
                trie.children[c - 'a'] = new Trie();
            }
            trie = trie.children[c - 'a'];
            trie.count++;
        }
        trie.isEndOfWord = true;
    }
}

public class Problem4 {
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str : strs) {
            if (str.length() == 0) {
                return "";
            }
            trie.insert(str);
        }
        String prefix = "";
        Trie node = trie;
        node = node.children[strs[0].charAt(0) - 'a'];
        if (node.count != strs.length) {
            return prefix;
        }
        prefix += strs[0].charAt(0);
        for (int i = 1; i < strs[0].length(); i++) {
            node = node.children[strs[0].charAt(i) - 'a'];
            if (node != null && node.count != strs.length) {
                break;
            }
            prefix += strs[0].charAt(i);
        }
        return prefix;
    }
}
