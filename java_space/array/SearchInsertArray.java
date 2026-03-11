package array;
public class SearchInsertArray {

     public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        
        int left = 0 , right = nums.length - 1 ;
        while (left <= right) {
            int index = ( right - left ) / 2 + left;
            int value = nums[index];
            if(value == target) return index;
            if(value > target) right = index - 1;
            if(value < target ) left = index + 1;
        }
        return left;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1};
        SearchInsertArray array = new SearchInsertArray();

        System.out.println(array.searchInsert(nums, 2));
    }
}