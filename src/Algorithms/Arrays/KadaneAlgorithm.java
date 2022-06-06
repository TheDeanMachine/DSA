package Algorithms.Arrays;

public class KadaneAlgorithm {

    public static int maxSubArray(int[] nums) {
        int curr = 0;
        int max = Integer.MIN_VALUE;

        for(int num: nums) {
            curr = Math.max(curr + num, num);
            max = Math.max(max, curr);
        }
        return max;
    }

    public static void main(String[] args) {
        int[]  array = {1, 3, 8, -2, 6, -8, 5};
        System.out.println(maxSubArray(array));
    }

}
