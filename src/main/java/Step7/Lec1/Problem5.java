package Step7.Lec1;

import java.util.Stack;

public class Problem5 {
    static void reverse(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int temp = s.pop();
        reverse(s);
        insertAtBottom(s, temp);
    }

    static void insertAtBottom(Stack<Integer> s, int x) {
        if (s.isEmpty()) {
            s.push(x);
            return;
        }
        int temp = s.pop();
        insertAtBottom(s, x);
        s.push(temp);
    }
}
