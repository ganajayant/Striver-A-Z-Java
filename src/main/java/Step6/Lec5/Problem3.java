package Step6.Lec5;

class Node {
    int data;
    Node next;
    Node bottom;

    public Node(int d) {
        this.data = d;
        this.bottom = null;
        this.bottom = null;
    }
}

public class Problem3 {
    private Node Merge(Node temp1, Node temp2) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                temp.bottom = new Node(temp1.data);
                temp1 = temp1.bottom;
            } else {
                temp.bottom = new Node(temp2.data);
                temp2 = temp2.bottom;
            }
            temp = temp.bottom;
        }
        while (temp1 != null) {
            temp.bottom = new Node(temp1.data);
            temp1 = temp1.bottom;
            temp = temp.bottom;
        }
        while (temp2 != null) {
            temp.bottom = new Node(temp2.data);
            temp2 = temp2.bottom;
            temp = temp.bottom;
        }
        return dummy.bottom;
    }

    Node flatten(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node temp1 = flatten(head.next);
        Node temp2 = head;
        head = Merge(temp1, temp2);
        return head;
    }
}
