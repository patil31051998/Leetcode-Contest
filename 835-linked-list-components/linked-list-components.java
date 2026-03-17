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
    public int numComponents(ListNode head, int[] nums) {
        int count, numComponents;
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums) {
            numSet.add(num);
        }
        count = numComponents = 0;
        ListNode curr = head;
        while(curr != null) {
            if(numSet.contains(curr.val)) {
                if(count == 0) {
                    numComponents++;
                }
                count++; 
            } else {
                count = 0;
            }
            curr = curr.next;
        }
        return numComponents;
    }
}