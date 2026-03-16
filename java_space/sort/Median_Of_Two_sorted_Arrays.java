package sort;

import java.util.List;
import java.util.stream.Collectors;

import array.*;

public class Median_Of_Two_sorted_Arrays{
    CombinationSumII combinationSumII = new CombinationSumII();
    public String printPretty(int[] arr , int target){
        List<List<Integer>> result = this.combinationSumII.combinationSum2(arr, target);
        String resultString = result.stream()
        .map(list -> list.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",", "[", "]")))
        .collect(Collectors.joining("\n"));

return resultString;
        
    }

    public static void main(String[] args) {
        Median_Of_Two_sorted_Arrays arrays = new Median_Of_Two_sorted_Arrays();
        int[] arr  = new int[]{1,2,3,4,5,6,7,8,9,10,9,1,2,2,1,4,5,6,3};
        System.out.println(arrays.printPretty(arr, 18));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0) return nums2.length % 2 == 0 ? ((double)( nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1 ] ) / 2) : nums2[nums2.length / 2]  ;
        if(nums2.length == 0) return nums1.length % 2 == 0 ? ((double)( nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1 ] ) / 2) : nums1[nums1.length / 2]  ;
        // inital var
        int index_num_1 = 0,index_num_2 =0;
        int[] num_final_list = new int[nums1.length + nums2.length];
        int final_list_index= 0;

        while (final_list_index != (nums1.length + nums2.length ) ){
            // 
            if(nums1[index_num_1] > nums2[index_num_2]){
                num_final_list[final_list_index] = nums2[index_num_2];
                final_list_index++;
                index_num_2++;
                if(index_num_2 == nums2.length) break;
            }
            else
             {
                num_final_list[final_list_index] = nums1[index_num_1];
                final_list_index++;
                index_num_1++;
                if(index_num_1 == nums1.length) break;
            }
        }

        while(index_num_1 < nums1.length){
            num_final_list[final_list_index]=nums1[index_num_1];
            final_list_index++;
                index_num_1++;
        }
        while(index_num_2 < nums2.length){
             num_final_list[final_list_index] = nums2[index_num_2];
                final_list_index++;
                index_num_2++;
        }

        return num_final_list.length % 2 == 0 ? ( (double )  (num_final_list[num_final_list.length / 2] + num_final_list[(num_final_list.length / 2) - 1]) /2 ): num_final_list[num_final_list.length / 2] ;
    }
    
}
