package Step17.Lec2;

class Problem2Node {
    Problem2Node[] links;
    boolean flag;

    Problem2Node() {
        links = new Problem2Node[26];
        flag = false;
    }

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    Problem2Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Problem2Node node) {
        links[ch - 'a'] = node;
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }
}

class Problem2Trie {
    private Problem2Node root;

    Problem2Trie() {
        root = new Problem2Node();
    }

    void insert(String word) {
        Problem2Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                node.put(ch, new Problem2Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    boolean checkIfPrefixExist(String word) {
        Problem2Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return false;
            }
            node = node.get(ch);
            if (!node.isEnd()) {
                return false;
            }
        }
        return true;
    }
}

public class Problem2 {

    public static String completeString(int n, String[] a) {
        Problem2Trie trie = new Problem2Trie();
        for (String it : a) {
            trie.insert(it);
        }
        String longest = "";
        for (String it : a) {
            if (trie.checkIfPrefixExist(it)) {
                if (it.length() > longest.length()) {
                    longest = it;
                } else if (it.length() == longest.length() && it.compareTo(longest) < 0) {
                    longest = it;
                }
            }
        }
        if (longest.equals("")) {
            return "None";
        }
        return longest;
    }
}