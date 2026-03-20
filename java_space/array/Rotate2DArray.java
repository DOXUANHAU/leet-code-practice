package array;

public class Rotate2DArray {
   public void rotate(int[][] matrix) {
        // get size of the matrix
        int n = matrix.length;

        // swap i and j index of all element 
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[i].length; j++) {
                int temp = matrix[j][i] ;
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        // reversing after swap 
           for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                //  calculate the index of an element in a array 
                int index = (n-1) - j;
                int temp  = matrix[i][index];
                matrix[i][index]= matrix[i][j];
                matrix[i][j] =temp;
            }
        }



             for (int i = 0; i < matrix.length; i++) {          // rows
            for (int j = 0; j < matrix[i].length; j++) {   // columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // move to next line
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        Rotate2DArray rotate2dArray = new Rotate2DArray();
        rotate2dArray.rotate(matrix);
    }
}
