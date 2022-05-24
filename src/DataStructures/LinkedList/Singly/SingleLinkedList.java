package DataStructures.LinkedList.Singly;

public class SingleLinkedList {

    private Node head; // pointer to start of list
    private Node tail; // pointer to end of list
    private int length;

    // creates empty list
    public SingleLinkedList() {
        head = null;
        tail = null;
    }

    // creates list with a value
    public SingleLinkedList(int value) {
        head = new Node(value);
        tail = head;
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
        return "SingleLinkedList {" + " head = " + getHead() + ", tail = " + getTail() + " }";
    }

    public void append(int value) {
        if (head == null) { // if list is empty
            head = new Node(value);
            tail = head;
        } else {
            Node newNode = new Node(value); // create a new node with no pointers
            tail.setNext(newNode); // assign current tails next pointer to the new node
            tail = newNode; // newNode is now the tail
        }
        length++;
    }

    public void prePend(int value){
        if (head == null) { // if list is empty
            head = new Node(value);
            tail = head;
        } else {
            Node newNode = new Node(value); // create a new node with no pointers
            newNode.setNext(head); // assign newNode next pointer to the head node
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

        if( (head == null) || (index == 0) ) { // if list is empty or index 0
            prePend(value);
            return;
        }
        if(index >= length) { // if given index is greater than size of list
            append(value);
            return;
        }

        Node previousNode = traverseToIndex(index - 1); // get previous node
        Node currentNode = previousNode.getNext(); // get the node corresponding to the index
        Node newNode = new Node(value, currentNode); // create a new node and point its "next" pointer to the "currentNode"
        previousNode.setNext(newNode); // set the previous node to the inserted new node
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
        if ( index == 0 ) {
            Node nextNode = head.getNext();
            head.setNext(null);
            head = nextNode;
            length--;
            return;
        }

        // get pointers
        Node previousNode = traverseToIndex(index - 1); // get previous node
        Node currentNode = previousNode.getNext(); // get the node corresponding to the index
        Node nextNode = currentNode.getNext(); // get the next node

        // remove node
        previousNode.setNext(nextNode);
        currentNode.setNext(null);
        length--;

        if(nextNode == null) { // if tail node
            tail = previousNode; // update tail
        }
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
        SingleLinkedList myList = new SingleLinkedList();
        myList.append(2);
        myList.prePend(1);
        myList.append(3);
        myList.displayList(); // 1->2->3

        myList.append(5);
        myList.insert(3, 4);
        myList.displayList(); // 1->2->3->4->5

        myList.insert(0, 0); // insert head
        myList.insert(6, 6); // insert tail
        myList.displayList(); // 0->1->2->3->4->5->6

        myList.remove(0); // remove head
        myList.remove(5); // remove tail
        myList.displayList();  // 1->2->3->4-5
        System.out.println(myList); // check head and tail are updated after above operations
        System.out.println("Size of list is " + myList.length);

        myList.remove(4);
        myList.remove(3);
        myList.remove(2);
        myList.remove(1);
        myList.remove(0); // remove last node
        myList.displayList();

    }

}

