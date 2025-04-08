package algorthim_patterns.slowfastpoints;

public class CheckPalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, prev = null;

        //Find middle and reverse
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode temp = slow;
            slow = slow.next;
            temp.next = prev;
            prev = temp;
        }
        // If linked list has number of node id old -> skip
        if (fast != null) slow = slow.next;

        // Compare two half
        while (slow != null) {
            if (slow.val != prev.val) return false;
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }
}
