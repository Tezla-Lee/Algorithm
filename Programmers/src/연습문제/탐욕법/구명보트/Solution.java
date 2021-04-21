package 연습문제.탐욕법.구명보트;

public class Solution {
    public int solution(int[] people, int limit) {
        int[] weight = new int[241];
        int count = 0;

        for (int i : people) {
            weight[i]++;
        }

        for (int i = 40; i <= limit - 40; i++) {
            int index = 0;
            while (weight[i] != 0) {
                if (limit - i - index <= i) {
                    break;
                }
                int temp = Math.min(weight[limit - i - index], weight[i]);
                weight[i] -= temp;
                weight[limit - i - index] -= temp;
                count += temp;
                index++;
            }
        }

        for (int i = 40; i < 241; i++) {
            if (i * 2 <= limit) {
                count += weight[i] / 2;
                weight[i] -= (weight[i] / 2) * 2;
            }
            count += weight[i];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(new Solution().solution(new int[]{70, 80, 50}, 100));
//        System.out.println(new Solution().solution(new int[]{40}, 40));
    }
}
