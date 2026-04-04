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

    private ListNode getMiddleNode(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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

    public void print(ListNode head) {
        while(head != null) {
            System.out.printf(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public void reorderList(ListNode head) {
        ListNode middle = getMiddleNode(head);
        ListNode nextPart = middle.next;
        middle.next = null;
        ListNode secondList = reverse(nextPart);
        ListNode dummyHead, curr;
        dummyHead = new ListNode(-1);
        curr = dummyHead;
        ListNode l1, l2;
        l1 = head;
        l2 = secondList;
        // print(l1);
        // print(l2);
        while(l1 != null && l2 != null) {
            // System.out.println(l1.val + ":" + l2.val);
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;
            curr.next = l2;
            curr = curr.next;
            l2 = l2.next;
        }
        if(l1 != null) {
            curr.next = l1;
            curr.next.next = null;
        }
    }
}