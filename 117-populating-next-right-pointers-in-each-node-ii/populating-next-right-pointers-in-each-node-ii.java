/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) {
            return root;
        }
        if(root.left != null) {
            Node leftNext = root.right;
            Node curr = root;
            while(leftNext == null && curr.next != null) {
                leftNext = curr.next.left != null ? curr.next.left : curr.next.right;
                curr = curr.next;
            }
            root.left.next = leftNext;
        }
        Node rightNext = null;
        Node curr = root;
        while(rightNext == null && curr.next != null) {
            rightNext = curr.next.left != null ? curr.next.left : curr.next.right;
            curr = curr.next;
        }
        if(root.right != null) {
            root.right.next = rightNext;
        }
        connect(root.right);
        connect(root.left);
        return root;
    }
}