package Step6.Lec3;

public class Problem10 {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        if (head.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
