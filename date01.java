import java.util.HashMap;
import java.util.Map;

public class Date_1 {
public int[] twoSumV2(int[] nums, int target) {
        // loop the first with i 
        aba:
        for (int i = 0; i < nums.length  ; i++) {
            for(int j = i + 1 ; j < nums.length ;j++){
                // best case 
                if ( nums[i] + nums[j] == target) return new int[]{i,j};
                // worst case 
                if (i == nums.length -2 && j == nums.length - 1 ) break aba;
                }
        }
        return new int[]{-1};
    }

      public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> temp = new HashMap<>();
        temp.put(nums[0],0);
        for (int i = 1; i < nums.length; i++) {
            int complement = target - nums[i];
            if ( temp.containsKey(complement)){
                return new int[]{temp.get(complement),i};
            }
            temp.put(nums[i],i);
        }
        return new int[]{-1};

    }
public String toString(int[] arr) {
    String result = "";
    for (int i = 0; i < arr.length; i++) {
        result += arr[i] + ", ";
    }
    return result;

}
  
    
    public static void main(String[] args) {
        Date_1 a = new Date_1();
        System.out.println(a.toString(a.twoSumV2(new int[]{2,7,11,15}, 9)));
    }
}
