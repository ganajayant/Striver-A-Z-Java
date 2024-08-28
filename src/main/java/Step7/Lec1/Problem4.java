package Step7.Lec1;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class Problem4 {
    private void helper(LinkedList<Integer> arr, Stack<Integer> stacky, int index) {
        if (index == stacky.size()) {
            Collections.sort(arr);
            return;
        }
        arr.add(stacky.pop());
        helper(arr, stacky, index);
    }

    private Stack<Integer> AddStack(LinkedList<Integer> arr, Stack<Integer> stack, int size) {
        if (stack.size() == size) {
            return stack;
        }
        stack.add(arr.removeLast());
        return AddStack(arr, stack, size);
    }

    public Stack<Integer> sort(Stack<Integer> s) {
        LinkedList<Integer> arr = new LinkedList<>();
        helper(arr, s, 0);
        return AddStack(arr, new Stack<>(), arr.size());
    }

}
