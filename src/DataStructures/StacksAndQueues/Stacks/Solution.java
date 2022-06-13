package DataStructures.StacksAndQueues.Stacks;

import java.util.Stack;

public class Solution {

    /**
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * An input string is valid if:
     *  1. Open brackets must be closed by the same type of brackets.
     *  2. Open brackets must be closed in the correct order.
     */
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {         // check for matching closing brace
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {  // check for matching closing brace
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {  // check for matching closing brace
                stack.pop();
            } else {
                stack.push(c); // add opening braces to the stack
            }
        }
        return stack.isEmpty();
    }

    /**
     * Print out the next greater element for every element in the array.
     * The next greater element for a given element is the first greater element on the right side of the array.
     * If no greater element exists, then the next greater element is a sentinel value, -1
     */
    public static void printNextGreaterElement(int[] arr) {
        if (arr.length == 0) {
            System.out.println();
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];
            if (!stack.isEmpty()) {
                int popped = stack.pop();
                while (popped < next) {
                    System.out.println(popped + " --> " + next);
                    if (stack.isEmpty()) {
                        break;
                    }
                    popped = stack.pop();
                }

                if (popped > next) {
                    stack.push(popped);
                }
            }
            stack.push(next);
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + " --> " + -1);
        }
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("{{({})}}"));

        printNextGreaterElement(new int[]{16, 7, 2, 15});

    }
}
