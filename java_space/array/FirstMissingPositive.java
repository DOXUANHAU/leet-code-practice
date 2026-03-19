package array;
public class  FirstMissingPositive {
   public int firstMissingPositive(int[] nums) {

    for (int i = 0; i < nums.length; i++) {
        // swap number into the right at index = num[i] - 1
        // ignore the negative and duplicate number 
        while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]) {
            int temp = nums[i];
            nums[i] = nums[temp - 1];
            nums[temp - 1] = temp;
        }
    }


    // search if num[i] does not equal i + 1 ==> missing value 
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != i + 1) {
            return i + 1;
        }
    }

    return nums.length + 1;
}
public static void main(String[] args) {
    int[] nums = new int[] {-1,5,2,6,8,4,2,5};
    FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
    System.out.println(firstMissingPositive.firstMissingPositive(nums));
}
    
}