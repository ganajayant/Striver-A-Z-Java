package Step6.Lec4;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }
}

public class Problem1 {
    static Node deleteAllOccurOfX(Node head, int x) {
        while (head != null && head.data == x) {
            head = head.next;
            head.prev = null;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.data == x) {
                Node prev = temp.prev;
                Node next = temp.next;
                prev.next = next;
                if (next != null) {
                    next.prev = prev;
                }
                temp = next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
