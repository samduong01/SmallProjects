public class DoublyLinkedList {
    Node head;

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int d){
            data = d;
        }
    }

    public void insertAfter(Node prev, int data){
        Node newNode = new Node(data);

        newNode.next = prev.next;

        prev.next = newNode;

        newNode.prev = prev;

        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    public void insertBefore(Node next, int data){
        Node newNode = new Node(data);

        newNode.prev = next.prev;

        next.prev = newNode;

        newNode.next = next;

        if (newNode.prev != null) {
            newNode.prev.next = newNode;
        }
    }

    public void removeEnd(Node node){
        Node last = null;
        while (node != null) {
            last = node;
            node = node.next;
        }
        last.prev.next = null;
        last = null;
    }

    public void removeFirst(){
        head = head.next;
        head.prev = null;

    }

    public void remove(Node node){
        if(node.prev != null) {
            node.prev.next = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        }

        node.next = null;
        node.prev = null;
    }

    public void insertEnd(int data){
        Node newNode = new Node(data);

        Node last = head;

        newNode.next = null;

        if (head == null) {
            newNode.prev = null;
            head = newNode;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;

        newNode.prev = last;
    }

    public void print(){
        System.out.println();
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void moveToFront(Node node){
        remove(node);
        node.next = head;
        node.next.prev = node;
        head = node;
    }

    public void moveToEnd(Node node){
        remove(node);
        insertEnd(node.data);
    }
}
