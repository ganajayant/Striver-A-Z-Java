package Step6.Lec1;

class Node {
    int data;
    Node next;

    Node() {
        data = 0;
    }

    Node(int d) {
        data = d;
    }
}

public class Problem1 {
    static Node constructLL(int arr[]) {
        Node head = new Node();
        Node temp = head;
        for (int i : arr) {
            temp.next = new Node(i);
            temp = temp.next;
        }
        return head.next;
    }
}