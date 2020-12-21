package CountNegativeNumbersInASortedMatrix;

import java.util.Arrays;

public class Solution {
    public int countNegatives(int[][] grid) {
        int[] numbers = new int[grid.length * grid[0].length];
        int index = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                numbers[index++] = grid[i][j];
            }
        }
        Arrays.sort(numbers);

        return binarySearch(numbers);
    }

    public int binarySearch(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        if (left == right) {
            return arr[0] >= 0 ? 0 : 1;
        }
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        while (mid > 0 && arr[mid] >= 0) {
            mid--;
        }
        return arr[mid] >= 0 ? mid : mid + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countNegatives(new int[][]{{4, 0, 0, 1}, {3, 2, 1, 2}, {1, 1, 3, 8}, {9, 1, 2, 3}, {5, 5, 5, 5}}));
//        System.out.println(new Solution().countNegatives(new int[][]{{4, 0, 0, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}, {-5, -5, -5, -5}}));
//        System.out.println();
//        System.out.println(new Solution().countNegatives(new int[][]{{7, 6, 6, 6, 3, 3, -2}, {-2, -3, -3, -3, -5, -5, -5}, {-2, -4, -5, -5, -5, -5, -5},
//                {-3, -5, -5, -5, -5, -5, -5}, {-4, -5, -5, -5, -5, -5, -5}, {-5, -5, -5, -5, -5, -5, -5}, {-5, -5, -5, -5, -5, -5, -5}, {-5, -5, -5, -5, -5, -5, -5}}));
//        System.out.println();
//        System.out.println(new Solution().countNegatives(new int[][]{{-1, -2, -3, -4, -5, -6, -2}, {-2, -3, -3, -3, -5, -5, -5}, {-2, -4, -5, -5, -5, -5, -5},
//                {-3, -5, -5, -5, -5, -5, -5}, {-4, -5, -5, -5, -5, -5, -5}, {-5, -5, -5, -5, -5, -5, -5}, {-5, -5, -5, -5, -5, -5, -5}, {-5, -5, -5, -5, -5, -5, -5}}));
    }
}