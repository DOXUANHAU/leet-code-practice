import java.util.ArrayList;
import java.util.List;

public class ThreeSum{
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        

        backtrack(nums, 3, 0, new ArrayList<>(), result);



        return result;
    }

  public void backtrack(int[] arr, int k, int start,
                                 List<Integer> temp,
                                 List<List<Integer>> result) {

        if (temp.size() == k && checkGivenValue(temp.get(0), temp.get(1),temp.get(2))) {

            if(checkContainInMotherList(result,temp)) return ;



            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            temp.add(arr[i]);              // chọn
            backtrack(arr, k, i + 1, temp, result);  // đi tiếp
            temp.remove(temp.size() - 1);  // quay lui
        }
    }

    public boolean checkGivenValue(int num1,int num2 , int num3){
        return num1 + num2 + num3 == 0;
    }

    private boolean checkContainInMotherList(List<List<Integer>> motherList , List<Integer> child){
        for (int i = 0; i < motherList.size(); i++) {

            List<Integer> value = motherList.get(i);
            if(value.contains(child.get(0)) && value.contains(child.get(1)) && value.contains(child.get(2))) return true;
            
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums ={-1,0,1,2,-1,-4};

        ThreeSum th = new ThreeSum();
        System.out.println(th.threeSum(nums));
    }

}