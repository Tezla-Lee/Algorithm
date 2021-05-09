package _2021_라AD.프로그래밍2;

import java.util.Arrays;

/**
 * https://www.acmicpc.net/problem/17298 와 비슷한 유형이니 참고
 */

class Solution {
    public int[] solution(int[] array) {
        int[] nearIndex = new int[array.length];
        Arrays.fill(nearIndex, -1);

        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > array[i]) {
                    if (nearIndex[i] == -1) {
                        nearIndex[i] = j;
                    } else if (nearIndex[i] - i >= i - j) {
                        nearIndex[i] = j;
                    }
                    break;
                } else if (array[j] < array[i]) {
                    nearIndex[j] = i;
                }
            }
        }

        return nearIndex;
    }
}
