package sort;

import java.util.Arrays;

class QuickSort {
    static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(arr, left, right);

        sort(arr, left, pivotIndex - 1);
        sort(arr, pivotIndex, right);
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
                left++;
                right--;
            }
        }

        return left;
    }

    static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 76, 43, 345, 1234, 4563, 124, 4, 0, 5, 7, 423, 534};
        int[] data = {66, 10, 1, 34, 5, -10};

        sort(nums, 0, nums.length - 1);
        sort(data, 0, data.length - 1);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(data));
    }
}