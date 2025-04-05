package algorthim_patterns.slowfastpoints;

public class FindMiddleOfLinkedListCycle {
    public ListNode find(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
