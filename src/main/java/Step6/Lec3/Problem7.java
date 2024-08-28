package Step6.Lec3;

public class Problem7 {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int count = 0;
        if (head.next == null) {
            return true;
        }
        while (fast != null && fast.next != null) {
            count += 2;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            count++;
        }
        if (count % 2 == 1) {
            slow = slow.next;
        }
        ListNode reversed = reverse(slow);
        while (reversed != null) {
            if (head.val != reversed.val) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
