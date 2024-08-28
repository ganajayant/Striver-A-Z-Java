package Step6.Lec2;

public class Problem3 {
    Node deleteNode(Node head, int x) {
        Node temp = head;
        while (x-- > 1) {
            temp = temp.next;
        }
        Node next = temp.next;
        if (next != null) {
            next.prev = temp.prev;
        }
        if (temp.prev == null) {
            return next;
        } else {
            temp.prev.next = next;
        }
        return head;
    }
}
