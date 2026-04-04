/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode reverse(ListNode head) {
        ListNode curr, prev;
        curr = head;
        prev = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode doubleIt(ListNode head) {
        ListNode rev = reverse(head);
        ListNode dummyHead, curr;
        curr = new ListNode(-1);
        dummyHead = curr;
        int carry = 0;
        while(rev != null) {
            int sum = rev.val * 2 + carry;
            ListNode node = new ListNode(sum % 10);
            curr.next = node;
            carry = sum / 10;
            curr = curr.next;
            rev = rev.next;
        }
        if(carry > 0) {
            ListNode node = new ListNode(carry);
            curr.next = node;
        }
        return reverse(dummyHead.next);
    }
}