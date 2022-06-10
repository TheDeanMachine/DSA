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

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("{{({})}}"));
    }
}
