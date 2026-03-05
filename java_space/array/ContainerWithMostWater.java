package array;
public class ContainerWithMostWater {

    public ContainerWithMostWater() {
    }

    
    // public int maxArea(int[] height){
        // if(height.length == 0) return 0;
        // int maxResult = 0;
        // for (int i = 0; i < height.length; i++) {
            // for (int j = i+1; j < height.length; j++) {
                // take all infor of two column 
                // int temp = height[i] >= height[j] ? height[j] * (j - i) : height[i] * (j - i);
                // if (maxResult <= temp) {
                    // maxResult = temp;
                // }
            // }
        // }
        // return maxResult;
    // }
    // 
    public int maxArea(int[] height){
        if(height.length == 0) return 0;
        int i =0,j = height.length -1 , result = 0 ,area ,h;
        while(i <= j){
        // calculate height status
        h = (height[i] <= height[j]) ? height[i] : height[j];
        // calculate value of area by min value at pointer and replace value index min
        area = h * (j -i );
        // reassign value for eresult 
        result = (result <= area) ? area : result;

        //  check if height at i < height at j then continues move 
        while(i <= j && height[i] <=  h) i++;
        // check the same logic as the line above
        while (i <= j && height[j] <= h )  j--;

        }
        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(c.maxArea(height));
    }
    
}