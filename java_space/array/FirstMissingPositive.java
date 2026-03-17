package array;
public class  FirstMissingPositive {
   public int firstMissingPositive(int[] nums) {
    int n = nums.length;

    for (int i = 0; i < n; i++) {
        while (nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]) {
            int temp = nums[i];
            nums[i] = nums[temp - 1];
            nums[temp - 1] = temp;
        }
    }

    for (int i = 0; i < n; i++) {
        if (nums[i] != i + 1) {
            return i + 1;
        }
    }

    return n + 1;
}
public static void main(String[] args) {
    int[] nums = new int[] {-1,5,2,6,8,4,2,5};
    FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
    System.out.println(firstMissingPositive.firstMissingPositive(nums));
}
    
}