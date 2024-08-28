package Step6.Lec1;

public class Problem5 {
    static boolean searchKey(int n, Node head, int key) {
        while (head != null) {
            if (head.data == key) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}
