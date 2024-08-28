package Step5.Lec2;

import java.util.Stack;

public class Problem8 {
    public String reverseWords(String s) {
        s = s.trim();
        Stack<String> stacky = new Stack<String>();
        StringBuilder temp = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                if (temp.toString().length() == 0) {
                    continue;
                } else {
                    stacky.add(temp.toString());
                    temp = new StringBuilder("");
                }
            } else {
                temp.append(ch);
            }
        }
        if (temp.toString() != "") {
            stacky.add(temp.toString());
        }
        temp = new StringBuilder("");
        while (!stacky.isEmpty()) {
            temp.append(stacky.pop());
            temp.append(" ");
        }
        return temp.toString().trim();
    }
}
