package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
      List<List<Integer>> list = new ArrayList<>();
        public List<List<Integer>> permuteUnique (int[] nums){
            boolean[] used = new boolean[nums.length];
            Arrays.sort(nums);
            backtracking(nums, nums.length, new ArrayList<>() , used);
            return list;
        }

        private void backtracking(int[] nums , int k  , List<Integer> holder ,boolean[] used){
            if(holder.size() == k) {
                list.add(new ArrayList<>(holder));
                return;
            }
            for (int i = 0;   i < nums.length; i++) {
                // condition is valid 
                if(used[i]) continue;
                // avoid duplicate
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                used[i] = true;
                holder.add(nums[i]);
           
                // backtrack 
                backtracking(nums, k,  holder, used);

                // undo 
                holder.remove(holder.size() - 1 );
                used[i] = false;
            }

        }
}