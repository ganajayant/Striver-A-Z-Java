package Step6.Lec2;

public class Problem2 {
    void addNode(Node head_ref, int pos, int data) {
        Node temp = head_ref;
        while (pos-- > 0) {
            temp = temp.next;
        }
        Node nextemp = temp.next;
        Node prevtemp = temp;
        Node newnode = new Node(data);
        newnode.next = nextemp;
        newnode.prev = prevtemp;
        if (nextemp != null) {
            nextemp.prev = newnode;
        }
        if (prevtemp != null) {
            prevtemp.next = newnode;
        }
    }
}
