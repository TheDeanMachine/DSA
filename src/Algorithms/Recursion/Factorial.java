package Algorithms.Recursion;

public class Factorial {

    public static long findFactorialRecursively(long number) {
        if (number == 1) {
            System.out.println(number + "! is: " + 1); // enhance out statement
            return 1; // base case
        }
        long temp = number * findFactorialRecursively(number - 1); // recursive case
        System.out.println(number + "! is: " + temp);
        return temp; // multiplication happens after the base case, as the call stack is popped off one by one
    }


    // normal method without all the out statements
//    public static long findFactorialRecursively(long number) { // O(n)
//        if (number == 1) {
//            return 1;
//        }
//        return number * findFactorialRecursively(number - 1);
//    }

    public static long findFactorialIteratively(long number) { // O(n)
        long result = 1;
        for (long i = number; i > 0; i--) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        findFactorialRecursively(5);
//        1! is: 1
//        2! is: 2
//        3! is: 6
//        4! is: 24
//        5! is: 120

    }
}