package skillchecklevel2._2nd.p2_h_index;

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        int index = citations.length - 1;
        int count = 1;
        while (true) {
            if (citations[index] > count) {
                index--;
                count++;
            }
            else if (citations[index] == count) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().solution(new int[]{3, 0, 6, 1, 5, 3, 4, 5, 6, 0, 1, 2, 3, 0}));
        System.out.println(new Solution().solution(new int[]{3, 3, 3}));
        System.out.println(new Solution().solution(new int[]{2, 0, 6, 1, 5}));
        System.out.println(new Solution().solution(new int[]{0, 1, 2, 3, 4}));
        System.out.println(new Solution().solution(new int[]{0, 0, 0, 0, 0}));
        System.out.println(new Solution().solution(new int[]{3, 0, 6, 1, 5, 6, 6, 6, 6, 6, 6, 7, 7}));
        System.out.println(new Solution().solution(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(new Solution().solution(new int[]{12, 11, 10, 9, 8, 1}));
    }
}
