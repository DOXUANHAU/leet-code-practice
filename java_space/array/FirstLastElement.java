package array;

public class FirstLastElement{
    public int[]  searchRange(int[] nums, int target){
        if(nums == null ) return new int[] {-1,-1};

        // find the element in nums using binary search 
        int left = 0;
        int right  = nums.length  - 1;
        boolean first = false;
        boolean last = false;
        while(left <= right){
            int index =  (( right - left ) / 2 ) + left;
            int value = nums[index];
            if(value == target) {
                left = right = index;
                if(nums.length == 1 ){
                    first = last  = true;
                    break;
                }
                // find the first and the last element 
                while(!first || !last ){
                    if(left -1 < 0  || nums[left - 1] != target){
                        first = true; 

                    }else{
                        left-=1;
                    }

                    if(right + 1 >= nums.length || nums[right + 1] != target ){
                        last = true;
                    }else{
                        right+=1;
                    }
                }
                break;
            }
            if(value > target) right = index - 1;
            
            if(value < target ) left = index + 1;
        }
        if(!first || !last) return new int[] {-1,-1};

        System.out.println(left+" : "+right);
        return new int[] {left,right};
    }
    public static void main(String[] args) {
        // int[] arr = new int[] {1,2,3,4,5,6,7,7,7,8,9,9,9};
        int nums[] = new int[] {1,1};
        FirstLastElement firstLastElement = new FirstLastElement();
        System.out.println(firstLastElement.searchRange(nums, 1));
    }
}