package sort;

public class InsertionSort {

    // check from 1 to n-1, if the current element is smaller than the previous one, then we need to insert it into the correct position in the sorted part of the array (the left side)
    public void insertionSort(int[] arr) {

        // Duyệt từ phần tử thứ 2 (index = 1)
        // Vì phần tử đầu tiên (index = 0) coi như đã sorted
        for (int i = 1; i < arr.length; i++) {

            // key là phần tử cần chèn vào đúng vị trí
            int key = arr[i];

            // j dùng để duyệt phần đã sắp xếp (bên trái)
            int j = i - 1;

            // Dịch các phần tử lớn hơn key sang phải
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // dịch phần tử sang phải
                j--; // lùi lại để tiếp tục so sánh
            }   

            // Sau khi tìm được vị trí phù hợp
            // chèn key vào
            arr[j + 1] = key;
        }


}

}
