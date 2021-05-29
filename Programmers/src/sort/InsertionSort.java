package sort;

import java.util.Arrays;

class InsertionSort {
    static void sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int prev = i - 1;

            while (prev >= 0 && temp < nums[prev]) {
                swap(nums, prev, prev + 1);
                prev--;
            }
        }
    }

    private static void swap(int[] nums, int target1, int target2) {
        int temp = nums[target1];
        nums[target1] = nums[target2];
        nums[target2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 76, 43, 345, 1234, 4563, 124, 4, 0, 5, 7, 423, 534};
        int[] data = {66, 10, 1, 34, 5, -10};

        sort(nums);
        sort(data);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(data));
    }
}
