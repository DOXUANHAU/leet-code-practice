package sort;
public class SortColors {
    public void sortColors(int[] nums) { 
        // using insertionSort 
        if(nums == null || nums.length == 0) return;
        // loop the array 
        for(int i = 1; i <  nums.length ; i++){
            // get the current value at i 
            int key = nums[i];
            // the previous value ;
            int j= i -1 ;

            // loop through all the previous index before the key value 
            // if nums[j] > key move 
            while(j >= 0 && nums[j] > key){
                nums[j + 1] = nums[j] ;// move the element to the right 1 index 
                j--; // step back to  compare 
            }

            // after find the suitable position
            nums[j + 1] = key ;
        }
    }
}