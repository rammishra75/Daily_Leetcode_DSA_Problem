class MyLinkedList {
   
    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
    
    Node head;
    Node tail;
    int NON; 

    public MyLinkedList() {
        head = null;
        tail = null;
        NON = 0;
    }
    
    public int get(int index) {
        // Index out of bounds check
        if(index < 0 || index >= NON || head == null) {
            return -1;
        } else {
            Node temp = head;
            for(int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp.val;
        }
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if(head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        NON++;            
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        NON++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > NON) {
            return;
        }
        if(index == 0) {
            addAtHead(val);
        } else if(index == NON) {
            addAtTail(val);
        } else {
            Node newNode = new Node(val);
            Node temp = head;
            for(int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            NON++;
        }
    }
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= NON || head == null) {
            return;
        } else if(head == tail) {
            head = null;
            tail = null;
            NON--;
        } else if(index == 0) { 
            head = head.next;
            NON--;
        } else if(index == NON - 1) { 
            Node temp = head;
            while(temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
            NON--;
        } else { 
            Node temp = head;
            for(int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            NON--;
        }
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