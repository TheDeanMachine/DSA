package Algorithms.Arrays;

public class KadaneAlgorithm {
    public static int maxSubArray(int[] nums) {
        int curr = 0;
        int max = Integer.MIN_VALUE;

        for(int num: nums) {
            curr = Math.max(num, curr + num);
            max = Math.max(max, curr);
        }
        return max;
    }


    // local_maximum at index i is the maximum of A[i] and the sum of A[i] and local_maximum at index i-1.
    public static int maxSubArray2(int[] nums) {
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            localMax = Math.max(nums[i], nums[i] + localMax);

            if (localMax > globalMax){
                globalMax = localMax;
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        int[]  array = {1, 3, 8, -2, 6, -8, 5};
        System.out.println(maxSubArray2(array));
    }

}
