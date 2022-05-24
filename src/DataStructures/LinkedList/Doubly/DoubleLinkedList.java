package DataStructures.LinkedList.Doubly;

public class DoubleLinkedList {

    private Node head;
    private Node tail;
    private int length;

    // creates empty list
    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    // creates list with a value
    public DoubleLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;
    }

    public void append(int value) {
        // create a new node with no pointers
        Node newNode = new Node(value);

        if (head == null) { // if list is empty
            head = newNode;
            tail = head;
        } else {
            tail.setNext(newNode); // assign current tails next pointer to the new node
            newNode.setPrevious(tail); // set newNode previous pointer to old tail
            tail = newNode; // newNode is now the tail
        }
        length++;
    }

    public void prePend(int value){
        // create a new node with no pointers
        Node newNode = new Node(value);

        if (head == null) { // if list is empty
            head = newNode;
            tail = head;
        } else {
            newNode.setNext(head); // assign newNode next pointer to the head node
            head.setPrevious(newNode);
            head = newNode; // newNode is now the head
        }
        length++;
    }


    public void displayList() {
        if(head == null) {
            System.out.println("Linked List Empty");
            return;
        }

        Node currentNode = head;
        System.out.print(currentNode.getValue());

        while ( currentNode.getNext() != null ) {
            currentNode = currentNode.getNext();
            System.out.print("->" + currentNode.getValue());
        }

        System.out.println();
    }

    public void insert(int index, int value) {

        if( (head == null) || (index == 0) ) { // edge case
            prePend(value);
            return;
        }
        if(index > length) { // edge case
            append(value);
            return;
        }

        Node currentNode = traverseToIndex(index); // get the node corresponding to the index
        Node previousNode = currentNode.getPrevious(); // get previous node
        Node newNode = new Node(value, currentNode, previousNode); // create a new node and point its "next" pointer to the "currentNode"
        previousNode.setNext(newNode); // set the previous node to the inserted new node
        length++;
    }

    // gets the node corresponding to index
    public Node traverseToIndex(int index) {
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }


    public static void main(String[] args) {
        DoubleLinkedList myList = new DoubleLinkedList();
        myList.append(2);
        myList.prePend(1);
        myList.append(3);
        myList.displayList(); // 1->2->3

        myList.append(5);
        myList.displayList();
        myList.insert(3, 4);
        myList.displayList(); // 1->2->3->4->5
        myList.insert(0, 0);
        myList.displayList(); // 0->1->2->3->4->5
    }

}


