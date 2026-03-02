public class RemoveDuplucatesFromSortedArray{
    public int removeDuplicates(int[] arr ){
        if(arr.length == 0 || arr == null ) return 0;


        int dupliCate = arr[0];
        int index = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] != dupliCate){
                dupliCate = arr[i];
                index++;
            }
        }
        
        return index;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplucatesFromSortedArray remove = new RemoveDuplucatesFromSortedArray();
        System.out.println(remove.removeDuplicates(nums));
    }
}s
