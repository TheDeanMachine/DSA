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

    public int getHead() {
        return head.getValue();
    }

    public int getTail() {
        return tail.getValue();
    }

    @Override
    public String toString() {
        return "DoubleLinkedList {" + " head = " + getHead() + ", tail = " + getTail() + " }";
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

    public void prepend(int value){
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

    public void displayListInReverse() {
        if(tail == null) {
            System.out.println("Linked List Empty");
            return;
        }

        Node currentNode = tail;
        System.out.print(currentNode.getValue());

        while ( currentNode.getPrevious() != null ) {
            currentNode = currentNode.getPrevious();
            System.out.print("->" + currentNode.getValue());
        }

        System.out.println();
    }

    public void insert(int index, int value) {

        if( (head == null) || (index == 0) ) { // edge case
            prepend(value);
            return;
        }
        if(index >= length) { // edge case
            append(value);
            return;
        }

        // get pointers
        Node currentNode = traverseToIndex(index); // get the node corresponding to the index
        Node previousNode = currentNode.getPrevious(); // get previous node

        // insert the node and update pointers
        Node newNode = new Node(value, currentNode, previousNode); // point "newNode"s "next" and "previous" pointers
        previousNode.setNext(newNode); // update previous node next to "newNode"
        currentNode.setPrevious(newNode); // update current node previous to "newNode"
        length++;
    }

    public void remove(int index) {
        // remove last node from list to make list empty
        if (length == 1) {
            head = null;
            tail = null;
            length--;
            return;
        }

        // remove head
        if (index == 0) {
            Node nextNode = head.getNext();
            head.setNext(null);
            nextNode.setPrevious(null);
            head = nextNode;
            length--;
            return;
        }

        // get pointers to the nodes
        Node currentNode = traverseToIndex(index);
        Node previousNode = currentNode.getPrevious();
        Node nextNode = currentNode.getNext();

        // remove the current/index node
        if(nextNode == null) { // if tail node
            previousNode.setNext(nextNode);
            currentNode.setNext(null);
            currentNode.setPrevious(null);
            tail = previousNode; // update tail
        } else {
            previousNode.setNext(nextNode);
            nextNode.setPrevious(previousNode);
            currentNode.setNext(null);
            currentNode.setPrevious(null);
        }
        length--;
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
        myList.prepend(1);
        myList.append(3);
        myList.displayList(); // 1->2->3

        myList.append(5);
        myList.insert(3, 4); // insert test
        myList.displayList(); // 1->2->3->4->5

        myList.insert(0, 0); // insert head
        myList.insert(6, 6); // insert tail
        myList.displayList(); // 0->1->2->3->4->5->6

        myList.remove(0); // remove head
        myList.remove(5); // remove tail
        myList.displayList();  // 1->2->3->4-5
        System.out.println(myList); // check head and tail are updated after above operations
        System.out.println("Size of list is " + myList.length);
        myList.displayListInReverse(); // does not modify just visits list in reverse

        myList.remove(4);
        myList.remove(3);
        myList.remove(2);
        myList.remove(1);
        myList.remove(0); // remove last node
        myList.displayList();
    }

}


