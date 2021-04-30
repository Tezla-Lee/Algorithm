package daily_temperature;

import java.util.Arrays;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] waitDays = new int[T.length];

        for (int i = T.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (T[j] >= T[i]) {
                    break;
                } else {
                    waitDays[j] = i - j;
                }

            }
        }

        return waitDays;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}