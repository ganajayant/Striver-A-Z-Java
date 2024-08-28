package Step6.Lec3;

import java.util.Stack;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class Problem14 {
    public static Node addOne(Node head) {
        Node temp = head;
        Stack<Node> stacky = new Stack<Node>();
        while (temp != null) {
            stacky.add(temp);
            temp = temp.next;
        }
        Node pop = stacky.pop();
        int sum = pop.data + 1;
        pop.data = sum % 10;
        sum /= 10;
        while (sum != 0 && !stacky.isEmpty()) {
            Node x = stacky.pop();
            sum += x.data;
            x.data = sum % 10;
            sum /= 10;
        }
        if (sum != 0) {
            Node newhead = new Node(sum);
            newhead.next = head;
            return newhead;
        }
        return head;
    }
}
