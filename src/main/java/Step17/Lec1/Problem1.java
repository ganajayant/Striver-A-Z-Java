package Step17.Lec1;

class Node {
    Node[] chars;
    boolean word;

    public Node() {
        this.chars = new Node[26];
        this.word = false;
    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (temp.chars[index] == null) {
                temp.chars[index] = new Node();
            }
            temp = temp.chars[index];
        }
        temp.word = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (temp.chars[index] == null) {
                return false;
            }
            temp = temp.chars[index];
        }
        return temp.word;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (temp.chars[index] == null) {
                return false;
            }
            temp = temp.chars[index];
        }
        return true;
    }
}

public class Problem1 {
}