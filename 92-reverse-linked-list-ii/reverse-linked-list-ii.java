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

    private ListNode[] getNodes(ListNode head, int left, int right) {
        int count = 1;
        ListNode[] nodes = new ListNode[4];
        ListNode curr = head;
        while(count <= right) {
            if(count == left - 1) {
                nodes[0] = curr;
            } else if(count == left) {
                nodes[1] = curr;
            }
            if(count == right) {
                nodes[2] = curr;
                nodes[3] = curr.next;
            }
            curr = curr.next;
            count++;
        }
        return nodes;
    }

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

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode leftPrevNode, rightNextNode, leftNode, rightNode;
        ListNode[] nodes = getNodes(head, left, right);
        leftPrevNode =  nodes[0];
        leftNode = nodes[1];
        rightNode = nodes[2];
        rightNextNode = nodes[3];
        rightNode.next = null;
        reverse(leftNode);
        leftNode.next = rightNextNode;
        if(leftPrevNode == null) {
            head = rightNode;
        } else {
            leftPrevNode.next = rightNode;
        }
        return head;
    }
}