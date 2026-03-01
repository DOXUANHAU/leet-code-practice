import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum{
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i -1 ]) continue;


            int j = i + 1;
            int k = nums.length - 1;


            while (j < k) {
                int total = nums[i] + nums[j] + nums[k];

                if(total > 0 ){
                    k-=1;
                }else if(total < 0){
                    j+=1;
                }else{
                    List<Integer> child = new ArrayList<>();

                    child.add(nums[i]);
                    child.add(nums[j]);
                    child.add(nums[k]);


                    result.add(child);

                    j+=1;

                    while(nums[j] == nums[j - 1] && j < k){
                        j+=1;
                    }

                }
            }
            
        }

        return result;
    }

 

//   public void backtrack(int[] arr, int k, int start,
//                                  List<Integer> temp,
//                                  List<List<Integer>> result) {

//         if (temp.size() == k && checkGivenValue(temp.get(0), temp.get(1),temp.get(2))) {

//             result.add(new ArrayList<>(temp));
//             return;
//         }

//         for (int i = start; i < arr.length; i++) {
//             if( i > start && arr[i] == arr[i-1]) continue;



//             temp.add(arr[i]);              // chọn
//             backtrack(arr, k, i + 1, temp, result);  // đi tiếp
//             temp.remove(temp.size() - 1);  // quay lui
//         }
//     }

//     public boolean checkGivenValue(int num1,int num2 , int num3){
//         return num1 + num2 + num3 == 0;
//     }

    
    public static void main(String[] args) {
        int[] nums2 = {34,55,79,28,46,33,2,48,31,-3,84,71,52,-3,93,15,21,-43,57,-6,86,56,94,74,83,-14,28,-66,46,-49,62,-11,43,65,77,12,47,61,26,1,13,29,55,-82,76,26,15,-29,36,-29,10,-70,69,17,49};

        ThreeSum th = new ThreeSum();

        long start = System.currentTimeMillis();

        System.out.println(th.threeSum(nums2));
        
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) + " ms");
    }

}