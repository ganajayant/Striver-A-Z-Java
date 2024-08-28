package Step6.Lec2;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int x) {
        this.data = x;
        next = null;
        prev = null;
    }
}

public class Problem1 {
    Node constructDLL(int arr[]) {
        Node head = new Node(1);
        Node temp = head;
        for (int i : arr) {
            temp.next = new Node(i);
            Node prev = temp;
            temp = temp.next;
            temp.prev = prev;
        }
        head.next.prev = null;
        return head.next;
    }
}
