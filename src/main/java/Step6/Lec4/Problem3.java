package Step6.Lec4;

public class Problem3 {
    Node removeDuplicates(Node head) {
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                Node duplicate = temp.next;
                temp.next = duplicate.next;
                if (duplicate.next != null) {
                    duplicate.next.prev = temp;
                }
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}
