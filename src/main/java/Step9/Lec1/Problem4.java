package Step9.Lec1;

import java.util.Stack;

public class Problem4 {
    class MyQueue {
        Stack<Integer> stacky1;
        Stack<Integer> stacky2;

        public MyQueue() {
            stacky1 = new Stack<>();
            stacky2 = new Stack<>();
        }

        public void push(int x) {
            stacky1.push(x);
        }

        public int pop() {
            while (!stacky1.isEmpty()) {
                stacky2.push(stacky1.pop());
            }
            int x = stacky2.pop();
            while (!stacky2.isEmpty()) {
                stacky1.push(stacky2.pop());
            }
            return x;
        }

        public int peek() {
            while (!stacky1.isEmpty()) {
                stacky2.push(stacky1.pop());
            }
            int x = stacky2.peek();
            while (!stacky2.isEmpty()) {
                stacky1.push(stacky2.pop());
            }
            return x;
        }

        public boolean empty() {
            return stacky1.isEmpty();
        }
    }
}
