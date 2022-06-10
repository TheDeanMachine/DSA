package DataStructures.StacksAndQueues.Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueStack {
    Stack<Integer> input;
    Stack<Integer> output;

    public QueueStack() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x); // stack method not recursive
    }

    public int pop() {
        peek();
        return output.pop(); // stack method not recursive
    }

    public int peek() {
        if (output.empty()) {
            while (!input.empty()) {
                output.push(input.pop()); // reverses the LIFO into FIFO
            }
        }
        return output.peek(); // stack method peek not recursive
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }

    public static void main(String[] args) {
        QueueStack myQueue = new QueueStack();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]

        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.pop()); // return 2, output is now empty, will fill "output" with "input" on next call
        System.out.println(myQueue.pop()); // return 3

        myQueue.empty(); // return false
    }
}

