package array;
public class RemoveElement {
     public int removeElement(int[] nums, int val) {
        if(nums.length == 0  || nums == null ) return 0;
        // count for num of change
        int k = 0 ;
        // loop throught the arr 
       for (int i = 0; i < nums.length ; i++) {
            if(nums[i] != val){
              nums[k] = nums[i];
              k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int nums[] = {2};
        RemoveElement element = new RemoveElement();
        System.out.println(element.removeElement(nums, 3));
    }
}
