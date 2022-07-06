package Algorithms.Recursion;

/**
 ************ When to use Recursion ****************
 * 1. Problem can be divided into a number of subproblems that are smaller instances of the same problem.
 * 2. Each instance of the subproblem is identical in nature.
 * 3. The solution of each subproblem can be combined to solve the problem at hand.
 *
 * Cons: Bad Space Complexity.
 */


/*
 Given a number N return the index value of the Fibonacci sequence,
 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
 the pattern of the sequence is that each value is the sum of the 2 previous values.
 */
public class Fibonacci {

    public static int fibonacciRecursively(int n) { //O(2^n)
        if(n < 2) {
            return n;
        }
        return  fibonacciRecursively(n - 1) + fibonacciRecursively(n - 2);
    }

    public static int fibonacciIteratively(int n) { //O(n)
        if(n == 0) {
            return 0;
        }
        int result = 1;
        int lastNumber = 0;
        int temp;
        for (int i = 1; i < n; i++) {
            temp = result;
            result += lastNumber;
            lastNumber = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fibonacciIteratively(10));
        System.out.println(fibonacciRecursively(10));
    }
}

