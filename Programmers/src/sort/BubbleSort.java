package sort;

import java.util.Arrays;

class BubbleSort {
    private static int[] sort(int[] nums) {
        int length = nums.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{1, 5, 76, 43, 345, 1234, 4563, 124, 4, 0, 5, 7, 423, 534})));
    }
}
