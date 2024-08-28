package Step6.Lec3;

public class Problem12 {
    static Node segregate(Node head) {
        int[] result = new int[3];
        Node temp = head;
        while (temp != null) {
            result[temp.data]++;
            temp = temp.next;
        }
        temp = head;
        int i = 0;
        while (temp != null) {
            if (result[i] == 0) {
                i++;
            } else {
                temp.data = i;
                temp = temp.next;
                result[i]--;
            }
        }
        return head;
    }
}
