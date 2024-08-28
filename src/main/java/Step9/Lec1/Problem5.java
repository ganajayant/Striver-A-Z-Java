package Step9.Lec1;

class StackNode {
    int data;
    StackNode next;

    StackNode(int a) {
        data = a;
        next = null;
    }
}

public class Problem5 {
    class MyStack {
        StackNode top;

        void push(int a) {
            if (top == null) {
                top = new StackNode(a);
            } else {
                StackNode temp = new StackNode(a);
                temp.next = top;
                top = temp;
            }
        }

        int pop() {
            if (top == null) {
                return -1;
            }
            int x = top.data;
            top = top.next;
            return x;
        }
    }
}
