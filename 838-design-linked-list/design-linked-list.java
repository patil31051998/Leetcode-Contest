class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class MyLinkedList {

    Node head;
    int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }
    
    public int get(int index) {
        if(size <= index) {
            return -1;
        }
        Node curr = head;
        int count = 0;
        while(count < index) {
            curr = curr.next;
            count++;
        }
        return curr.val;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        if(head == null) {
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        Node curr = head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) {
            return;
        }
        if(head == null && index != 0) {
            return;
        }
        if(index == 0) {
            addAtHead(val);
            return;
        }
        Node newNode = new Node(val);
        int count = 0;
        Node curr = head;
        while(count < index - 1) {
            curr = curr.next;
            count++;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        size++;
    }

    private void print(Node curr) {
        while(curr != null) {
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println();
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) {
            return;
        }
        if(head == null) {
            return;
        }
        if(index == 0) {
            head = head.next != null ? head.next : null;
            size--;
            return;
        }
        int count = 0;
        Node curr = head;
        while(count < index - 1) {
            curr = curr.next;
            count++;
        }
        if(curr.next != null) {
            curr.next = curr.next.next;
        }
        size--;
    }


}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */