public class ContainerWithMostWater {

    public ContainerWithMostWater() {
    }

    
    public int maxArea(int[] height){
        if(height.length == 0) return 0;
        int maxResult = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                // take all infor of two column 
                int temp = height[i] >= height[j] ? height[j] * (j -i) : height[i] * (j - i);
                if (maxResult <= temp) {
                    maxResult = temp;
                }
            }
        }
        return maxResult;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(c.maxArea(height));
    }
    
}