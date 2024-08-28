package Step6.Lec2;

public class Problem4 {
    public static Node reverseDLL(Node head) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node newhead = temp;
        while (temp != null) {
            Node prev = temp.prev;
            Node next = temp.next;
            temp.prev = next;
            temp.next = prev;
            temp = temp.next;
        }
        return newhead;
    }
}
