package DataStructures.LinkedList.Doubly;

class Node {
    private int value;  // the int value it contains
    private Node next;  // pointer to another node object
    private Node previous;

    // next and previous set to null, must be set in code
    public Node(int value) {
        this.value = value;
        next = null;
        previous = null;
    }

    // sets next and previous value to passed in node
    public Node(int value, Node next, Node previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
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

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}


