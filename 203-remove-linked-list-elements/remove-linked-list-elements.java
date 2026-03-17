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
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr, tempHead, temp;
        tempHead = new ListNode(-1);
        curr = tempHead;
        temp = head;
        while(temp != null) {
            if(temp.val != val) {
                curr.next = temp;
                curr = curr.next;
            }
            temp = temp.next;
        }
        curr.next = null;
        return tempHead.next;
    }
}