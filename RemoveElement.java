public class RemoveElement {
     public int removeElement(int[] nums, int val) {
        if(nums.length == 0 || nums.length == 1 || nums == null ) return 0;

        int val_total =1 ;
        // loop throught the arr 
       loop:for (int i = 0; i < nums.length ; i++) {
            if(nums[i] == val){
                val_total = 1;
                int j  = i + 1;
                while(nums[j] == val ){
                    val_total++;
                    j++;
                    if(j == nums.length) break loop;
                }  
             int temp = nums[i];
             nums[i] = nums[j];
             nums[j] = temp;
            }
             
            

        }

        return nums.length - val_total;
    }

    public static void main(String[] args) {
        int nums[] = {3,3};

        RemoveElement element = new RemoveElement();
        System.out.println(element.removeElement(nums, 5));
    }
}
