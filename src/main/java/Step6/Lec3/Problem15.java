package Step6.Lec3;

public class Problem15 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        ListNode temp1 = l1, temp2 = l2;
        int carry = 0;
        while (temp1 != null && temp2 != null) {
            int sum = temp1.val + temp2.val + carry;
            temp.next = new ListNode(sum % 10);
            carry = sum / 10;
            temp1 = temp1.next;
            temp2 = temp2.next;
            temp = temp.next;
        }
        while (temp1 != null) {
            int sum = temp1.val + carry;
            temp.next = new ListNode(sum % 10);
            carry = sum / 10;
            temp1 = temp1.next;
            temp = temp.next;
        }
        while (temp2 != null) {
            int sum = temp2.val + carry;
            temp.next = new ListNode(sum % 10);
            carry = sum / 10;
            temp2 = temp2.next;
            temp = temp.next;
        }
        if (carry > 0) {
            temp.next = new ListNode(carry);
        }
        return head.next;
    }
}
