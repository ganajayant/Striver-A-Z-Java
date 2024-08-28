package Step9.Lec1;

import java.util.Stack;

public class Problem7 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                st.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (st.empty()) {
                    return false;
                }
                if (ch == '}' && st.peek() == '{') {
                    st.pop();
                } else if (ch == ']' && st.peek() == '[') {
                    st.pop();
                } else if (ch == ')' && st.peek() == '(') {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        return st.empty();
    }
}
