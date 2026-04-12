package array; 


public class IncreaseArray {

    public int[] solution(int[] nums){
        for(int i = nums.length - 1; i >= 0 ; i-- ){
            if(nums[i] < 9 ){
                nums[i] += 1; 
                return nums;
            }

                nums[i] = 0;
        }
        // all value is 9 
        int[] dp =new int[nums.length + 1] ;
        dp[0] = 1;
        return dp;

    }
}