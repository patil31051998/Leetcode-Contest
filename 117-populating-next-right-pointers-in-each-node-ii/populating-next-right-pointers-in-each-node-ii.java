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
            if(root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNextNode(root.next);
            }
        }
        
        if(root.right != null) {
            root.right.next = findNextNode(root.next);
        }

        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node findNextNode(Node root) {
        while(root != null) {
            if(root.left != null) {
                return root.left;
            } 
            if(root.right != null) {
                return root.right;
            }
            root = root.next;
        }
        return null;
    }
}