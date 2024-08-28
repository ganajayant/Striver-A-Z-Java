package Step6.Lec3;

public class Problem11 {
    private ListNode Middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode Merge(ListNode head1, ListNode head2) {
        ListNode temp1 = head1, temp2 = head2;
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                temp.next = new ListNode(temp1.val);
                temp1 = temp1.next;
            } else {
                temp.next = new ListNode(temp2.val);
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        while (temp1 != null) {
            temp.next = new ListNode(temp1.val);
            temp1 = temp1.next;
            temp = temp.next;
        }
        while (temp2 != null) {
            temp.next = new ListNode(temp2.val);
            temp2 = temp2.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = Middle(head);
        ListNode lefthead = head;
        ListNode righthead = middle.next;
        middle.next = null;
        lefthead = sortList(lefthead);
        righthead = sortList(righthead);
        return Merge(lefthead, righthead);
    }
}
