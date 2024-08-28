package Step6.Lec1;

public class Problem4 {
    public static int getCount(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
