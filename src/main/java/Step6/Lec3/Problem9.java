package Step6.Lec3;

public class Problem9 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        while (n-- > 0) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if (slow.next == null) {
            return head;
        }
        slow.next = slow.next.next;
        return head;
    }
}
