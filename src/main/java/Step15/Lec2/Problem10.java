package Step15.Lec2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair {
    String str;
    int translength;

    public Pair(String str, int translength) {
        this.str = str;
        this.translength = translength;
    }
}

public class Problem10 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String string : wordList) {
            set.add(string);
        }
        set.remove(beginWord);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 0));
        while (!q.isEmpty()) {
            Pair temp = q.poll();
            String str = temp.str;
            int translength = temp.translength;
            if (str.equals(endWord)) {
                return translength + 1;
            }
            for (int i = 0; i < str.length(); i++) {
                for (char j = 'a'; j < 'z'; j++) {
                    char[] chararray = str.toCharArray();
                    chararray[i] = j;
                    String replace = new String(chararray);
                    if (set.contains(replace)) {
                        set.remove(replace);
                        q.add(new Pair(replace, translength + 1));
                    }
                }
            }
        }
        return 0;
    }
}
