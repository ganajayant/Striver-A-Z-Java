package Step9.Lec4;

import java.util.Stack;

public class Problem3 {
    private boolean knows(int M[][], int i, int j) {
        if (M[i][j] == 1) {
            return true;
        }
        return false;
    }

    int celebrity(int M[][], int n) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            s.push(i);
        }
        while (s.size() > 1) {
            int a = s.pop();
            int b = s.pop();
            if (knows(M, a, b) && !knows(M, b, a)) {
                s.push(b);
            }
            if (knows(M, b, a) && !knows(M, a, b)) {
                s.push(a);
            }
        }
        if (s.size() == 0) {
            return -1;
        }
        int possiblerow = s.peek();
        for (int integer : M[possiblerow]) {
            if (integer != 0) {
                return -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == possiblerow) {
                continue;
            }
            if (M[i][possiblerow] != 1) {
                return -1;
            }
        }
        return possiblerow;
    }
}