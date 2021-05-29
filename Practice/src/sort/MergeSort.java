package sort;

import java.util.Arrays;

class MergeSort {
    static void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] result = new int[nums.length];
        int left = start;
        int right = mid + 1;
        int index = start;

        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {
                result[index++] = nums[left++];
            } else {
                result[index++] = nums[right++];
            }
        }

        while (left <= mid) {
            result[index++] = nums[left++];
        }
        while (right <= end) {
            result[index++] = nums[right++];
        }

        System.arraycopy(result, start, nums, start, end - start);
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
