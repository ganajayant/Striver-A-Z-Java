package Step9.Lec1;

import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {
    class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q1.add(x);
        }

        public int pop() {
            while (q1.size() != 1) {
                q2.add(q1.poll());
            }
            int x = q1.poll();
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
            return x;
        }

        public int top() {
            while (q1.size() != 1) {
                q2.add(q1.poll());
            }
            int x = q1.peek();
            q2.add(q1.poll());
            while (!q2.isEmpty()) {
                q1.add(q2.poll());
            }
            return x;
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
