package DataStructures.StacksAndQueues.Stacks;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackArray {
    private List<Integer> array = new ArrayList<>();

    public void isEmpty() {
        System.out.println("Stack is empty!");
    }

    public int peak() {
        if(array.size() == 0) {
            isEmpty();
            return -1;
        }
        return array.get(array.size() - 1);
    }

    public int pop() {
        if(array.size() == 0) {
           isEmpty();
           return -1;
        }
        return array.remove(array.size() - 1);
    }

    public void push(int value) {
        array.add(value);
    }

    public void printStack() {
        if (array.isEmpty()) {
            isEmpty();
            return;
        }

        for (int i = array.size() - 1; i >= 0; i--) {
            System.out.println("^");
            System.out.println(array.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackArray stack = new StackArray();
        stack.push(5);
        System.out.println(stack.peak());
        System.out.println();

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
