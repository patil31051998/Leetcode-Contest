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
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 1;
        while(count < k && curr != null) {
            curr = curr.next;
            count++;
        }
        if(curr == null) {
            return head;
        }
        ListNode next = curr.next;
        curr.next = null;
        ListNode node = reverseKGroup(next, k);
        ListNode nextRev = reverse(head);
        head.next = node;
        return nextRev;
    }
}