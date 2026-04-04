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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums) {
            numSet.add(num);
        }
        ListNode tempHead, dummy, curr;
        dummy = new ListNode(-1);
        tempHead = dummy;
        curr = head;
        while(curr != null) {
            if(numSet.contains(curr.val)) {
                curr = curr.next;
            } else {
                dummy.next = curr;
                curr = curr.next;
                dummy = dummy.next; 
            }
        }
        dummy.next = null;
        return tempHead.next;
    }
}