public class MainDLL {
    public static void main(String[] args){
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insertEnd(6);

        doublyLinkedList.insertEnd(4);

        doublyLinkedList.insertEnd(1);

        doublyLinkedList.print();

        doublyLinkedList.insertAfter(doublyLinkedList.head.next, 8);
        doublyLinkedList.print();

        doublyLinkedList.insertBefore(doublyLinkedList.head.next, 10);
        doublyLinkedList.print();

        doublyLinkedList.remove(doublyLinkedList.head.next.next);
        doublyLinkedList.print();

        doublyLinkedList.removeEnd(doublyLinkedList.head.next.next);
        doublyLinkedList.print();

        doublyLinkedList.removeFirst();
        doublyLinkedList.print();

        doublyLinkedList.moveToFront(doublyLinkedList.head.next);
        doublyLinkedList.print();

        doublyLinkedList.moveToEnd(doublyLinkedList.head.next);
        doublyLinkedList.print();
    }
}
