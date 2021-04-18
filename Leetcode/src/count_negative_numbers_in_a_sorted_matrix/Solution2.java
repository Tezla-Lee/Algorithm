package count_negative_numbers_in_a_sorted_matrix;

import java.util.Arrays;

public class Solution2 {
    public int countNegatives(int[][] grid) {
        int[] numbers = new int[grid.length * grid[0].length];
        int index = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                numbers[index++] = grid[i][j];
            }
        }
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (i == 0) {
                if (numbers[i] > 0) {
                    return 0;
                }
            }
            if (numbers[i] >= 0) {
                return i;
            }
        }
        return numbers.length;
    }
}
