package DataStructures.StacksAndQueues.Queues;


public class QueueList {

    private Node first;
    private Node last;
    private int length;

    public QueueList() {
        first = null;
        last = null;
        length = 0;
    }

    public int peek() {
        if(first == null) {
            return  -1;
        }
        return first.getValue();
    }

    // adds an item to the back
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            first = newNode;
            last = newNode;
        }

        last.setNext(newNode);
        last = newNode;
        length++;
    }

    // removes an item from the front
    public void dequeue() {
        if(first == null) {
            return;
        }
        first = first.getNext();
        length--;

        if(length == 0) {
            last = null;
        }
    }

    public void printQueue() {
        if(first == null) {
            System.out.println("Queue is empty!");
            return;
        }

        Node currentNode = first;
        while (currentNode != null) {
            System.out.print(currentNode.getValue() + "->");
            currentNode = currentNode.getNext();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        QueueList queue = new QueueList();
        queue.enqueue(3);
        queue.enqueue(5);
        queue.enqueue(5);
        queue.printQueue(); // 3->5->5->
        queue.dequeue();
        queue.printQueue(); // 5->5->
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
    }


}
