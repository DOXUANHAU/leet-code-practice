package array;

import java.util.ArrayList;
import java.util.List;

public class Permutaions {
    List<List<Integer>> list = new ArrayList<>();
        public List<List<Integer>> solution (int[] nums){
            boolean[] used = new boolean[nums.length];
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

                used[i] = true;
                holder.add(nums[i]);
           
                // backtrack 
                backtracking(nums, k,  holder, used);

                // undo 
                holder.remove(holder.size() - 1 );
                used[i] = false;
            }

        }
    public static void main(String[] args) {

        Permutaions permutaions = new Permutaions();
        int[] nums  = new int[]{1,2,3};
        List<List<Integer>> list =  permutaions.solution(nums);
         for (List<Integer> inner : list) {
            for (Integer num : inner) {
                System.out.print(num + " ");
            }
        }
        
    }
}
