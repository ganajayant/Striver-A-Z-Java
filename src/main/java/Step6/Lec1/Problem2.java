package Step6.Lec1;

public class Problem2 {
    class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    Node insertAtBeginning(Node head, int x) {
        Node temp = new Node(x);
        temp.next = head;
        return temp;
    }

    // Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x) {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(x);
        return head;
    }
}
