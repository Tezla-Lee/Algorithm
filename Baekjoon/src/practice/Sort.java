package practice;

import java.util.Arrays;

public class Sort {
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    static void quickSort(int[] arr, int left, int right) {
        int pivotIndex = partition(arr, left, right);
        System.out.println(Arrays.toString(arr));

        if (left < pivotIndex - 1) {
            quickSort(arr, left, pivotIndex - 1);
        }
        if (pivotIndex < right) {
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(arr, left, right);
            }
        }
        return left;
    }

    static void swap(int[] arr, int index1, int index2) {
        int tmp1 = arr[index1];
        int tmp2 = arr[index2];

        arr[index1] = tmp2;
        arr[index2] = tmp1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5513, 53, 4534, 6534, 6, 457, 68, 6789, 789, 78, 0, 89786, 756, 3456, 235, 124, 345, 13453, 531, 4523412, 51, 9978, 4567, 457, 56, 2345, 76, 3512, 8, 78, 345, 23, 2, 45, 7, 9, 67, 6, 5};
        int[] arr2 = {1, 5513, 53, 4534, 6534, 6, 457, 68, 6789, 789, 78, 0, 89786, 756, 3456, 235, 124, 345, 13453, 531, 4523412, 51, 9978, 4567, 457, 56, 2345, 76, 3512, 8, 78, 345, 23, 2, 45, 7, 9, 67, 6, 5};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(arr2));
        quickSort(arr2, 0, arr2.length - 1);
//        System.out.println(arr2[arr2.length/2]);
//        partition(arr2, 0, arr2.length - 1);
        System.out.println(Arrays.toString(arr2));
    }
}