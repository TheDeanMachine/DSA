package Algorithms.Arrays;

import java.util.Arrays;

public class TwoSumArray {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[0];
        for(int x = 0; x < nums.length; x++) {
            for(int y = x + 1; y < nums.length; y++) {
                if ((nums[x] + nums[y]) == target) {
                    result = new int[]{x, y};
                    return result;
                }
            }
        }
        return result;
    }

    // algoExpert solution
    public static int[] twoNumberSum(int[] array, int targetSum) {
        for (int x = 0; x < array.length; x++) {
            for (int y = x + 1; y < array.length; y++) {
                if (array[x] + array[y] == targetSum) {
                    return new int[] { array[x], array[y] };
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5, 6, 7}, 9)));
    }
}
