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

     public void sortColorsV2(int[] nums) {
        // Dutch National Flag algorithm (one pass, in-place)
        // l: next position to place 0
        // m: current index being inspected
        // h: next position to place 2
        int l = 0, m =0 , h =nums.length-1;

        // Process elements until m crosses h.
        // Regions during execution:
        // [0 .. l-1]   -> all 0s
        // [l .. m-1]   -> all 1s
        // [m .. h]     -> unknown (to be processed)
        // [h+1 .. end] -> all 2s
        while(m<=h){
            // Case 1: current value is 0
            // Put it into the left region by swapping nums[m] with nums[l].
            // Then both l and m move forward.
            if(nums[m]==0){
                int temp = nums[l];
                nums[l] = nums[m];
                nums[m] = temp;
                l++;
                m++;
            }
            // Case 2: current value is 2
            // Put it into the right region by swapping nums[m] with nums[h].
            // Decrease h only.
            // Do NOT increase m here, because the value swapped from nums[h]
            // into nums[m] is unprocessed and must be checked next.
            else if(nums[m]==2) {
                    int temp = nums[m];
                    nums[m] = nums[h];
                    nums[h] = temp;
                    h--;
            }
            // Case 3: current value is 1
            // It is already in the middle region, just move m forward.
            else {
                m++;
            }
        }
    }
}