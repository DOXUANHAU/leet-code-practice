
public class Median_Of_Two_sorted_Arrays{
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
