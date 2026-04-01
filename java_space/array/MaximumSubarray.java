package array;

public class MaximumSubarray {
     public int maxSubArray(int[] nums) {
        int currentMax  = nums[0];
        int globalMax = nums[0]; // actually result return 
        

        // start from 1 because we already initialize currentMax and globalMax with nums[0]
        for(int i = 1; i < nums.length; i++){
            currentMax = Math.max(nums[i], currentMax + nums[i]); // dp[i] = Math.max(nums[i], dp[i-1] + nums[i])
            globalMax = Math.max(globalMax, currentMax); // globalMax = Math.max(globalMax, dp[i])
        }
        return globalMax;
    }

}
