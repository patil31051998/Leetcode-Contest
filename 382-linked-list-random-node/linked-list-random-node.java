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
import java.util.Random;
class Solution {

    Map<Integer, ListNode> indexNodeMap = new HashMap<>();
    Random random = new Random();

    public Solution(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while(curr != null) {
            indexNodeMap.put(count, curr);
            count++;
            curr = curr.next;
        }
    }
    
    public int getRandom() {
        int randomNumber = random.nextInt(indexNodeMap.size()); 
        return indexNodeMap.get(randomNumber).val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */