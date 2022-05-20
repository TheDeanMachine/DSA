package DataStructures.LinkedList.Singly;


class Node {
    private int value;  // the int value it contains
    private Node next;  // pointer to another node object

    // next set to null, must be set in code
    public Node(int value) {
        this.value = value;
        next = null;
    }

    // sets next value to passed in node
    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

