package DataStructures.StacksAndQueues.Stacks;

// Using linked list
public class StackList {
    private Node top;
    private Node bottom;
    private int length;

    public StackList() {
        top = null;
        bottom = null;
        length = 0;
    }

    public void isEmpty() {
        System.out.println("Stack is empty!");
    }

    public int peak() {
        if(length == 0) {
            isEmpty();
            return -1;
        }
        return top.getValue();
    }

    public int pop() {
        if(length == 0) {
            isEmpty();
            return -1;
        }

        Node tempTop = top;
        top = top.getNext();
        length--;

        if(length == 0) {
            bottom = null;
        }

        return tempTop.getValue();
    }

    public void push(int valueToPush) {
        top = new Node(valueToPush, top);
        if(length == 0) {
            bottom = top;
        }
        length++;
    }

    public void printStack() {
        if(top == null) {
            isEmpty();
            return;
        }

        Node currentNode = top;

        while (currentNode != null) {
            System.out.println("^");
            System.out.println(currentNode.getValue());
            currentNode = currentNode.getNext();
        }

        System.out.println();
    }

    public static void main(String[] args) {
        StackList stack = new StackList();
        stack.peak();
        stack.push(5);
        stack.printStack();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.printStack();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.printStack();
        stack.pop();
        stack.printStack();
    }

}


