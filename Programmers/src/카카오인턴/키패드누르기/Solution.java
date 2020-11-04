package 카카오인턴.키패드누르기;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 */
public class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[][] leftRight = new int[2][2];
        leftRight[0][0] = 3;
        leftRight[0][1] = 1;
        leftRight[1][0] = 3;
        leftRight[1][1] = 3;
        for (int i : numbers) {
            if (i == 1 || i == 4 || i == 7) {
                answer.append("L");
                leftRight[0] = keypad(i);
            } else if (i == 3 || i == 6 || i == 9) {
                answer.append("R");
                leftRight[1] = keypad(i);
            } else {
                if (Math.abs(leftRight[0][0] - keypad(i)[0]) + Math.abs(leftRight[0][1] - keypad(i)[1]) == Math.abs(leftRight[1][0] - keypad(i)[0]) + Math.abs(leftRight[1][1] - keypad(i)[1])) {
                    if (hand.equals("right")) {
                        answer.append("R");
                        leftRight[1] = keypad(i);
                    } else {
                        answer.append("L");
                        leftRight[0] = keypad(i);
                    }
                } else if (Math.abs(leftRight[0][0] - keypad(i)[0]) + Math.abs(leftRight[0][1] - keypad(i)[1]) > Math.abs(leftRight[1][0] - keypad(i)[0]) + Math.abs(leftRight[1][1] - keypad(i)[1])) {
                    answer.append("R");
                    leftRight[1] = keypad(i);
                } else {
                    answer.append("L");
                    leftRight[0] = keypad(i);
                }
            }
            System.out.println(answer + " " + i);
            System.out.println(Arrays.toString(keypad(i)));
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
    }

    public static int[] keypad(int n) {
        int[] arr = new int[2];
        if (n == 0) {
            arr[0] = 3;
            arr[1] = 2;
            return arr;
        }
        arr[0] = (n - 1) / 3;
        if (n % 3 == 0) {
            arr[1] = 3;
        } else {
            arr[1] = n % 3;
        }
        return arr;
    }
}
