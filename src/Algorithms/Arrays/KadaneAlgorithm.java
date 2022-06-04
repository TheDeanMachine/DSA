package Algorithms.Arrays;

public class KadaneAlgorithm {

    // DP solution
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length + 1]; //dp(i) = max sum of subarray ending at (i-1)'th index
        int i = 1;

        for(int num: nums) {
            dp[i] = Math.max(dp[i-1] + num, num);
            max = Math.max(max, dp[i++]);
        }

        return max;
    }

    // Kadane's Algorithm (Optimization of Above DP solution):
    // Since we only need DP[i-1] to calculate DP[i].
    // There is no need of storing all values, we can get our solution done by one variable as well.
    public int maxSubArray2(int[] nums) {
        int curr = 0;
        int max = Integer.MIN_VALUE;

        for(int num: nums) {
            // Same as DP[i] = Math.max(DP[i-1] + num, num);
            curr = Math.max(curr + num, num);
            max = Math.max(max, curr);
        }
        return max;
    }


}
