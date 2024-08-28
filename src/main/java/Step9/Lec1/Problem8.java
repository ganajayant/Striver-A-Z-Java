package Step9.Lec1;

import java.util.Stack;

class Pair<T, S> {
    T l;
    S m;

    public Pair(T l, S m) {
        this.l = l;
        this.m = m;
    }

    public T getKey() {
        return l;
    }

    public S getValue() {
        return m;
    }

}

class MinStack {
    private Stack<Pair<Integer, Integer>> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new Pair<Integer, Integer>(val, val));
        } else {
            int min = Math.min(stack.peek().getValue(), val);
            stack.push(new Pair<Integer, Integer>(val, min));
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek().getKey();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return 0;
        }
        return stack.peek().getValue();
    }
}

public class Problem8 {

}
