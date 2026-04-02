package array;

public class JumpGame {

      public boolean canJump(int[] nums) {
        // Greedy idea:
        // maxReach stores the farthest index we can reach so far.
        // If we ever arrive at an index beyond maxReach, that index is unreachable.
        int maxReach = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            // Current position cannot be reached from previous jumps.
            if(i > maxReach) return false;

            // Update the farthest reachable index from current position.
            // i + nums[i] means: from index i, we can jump up to nums[i] steps.
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        // We never got stuck before the end, so the last index is reachable.
        return true;
    }
}