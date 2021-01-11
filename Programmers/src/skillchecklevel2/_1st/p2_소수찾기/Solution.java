package skillchecklevel2._1st.p2_소수찾기;

import java.util.Arrays;

public class Solution {
    public int solution(String numbers) {
        count = 0;
        number = numbers.toCharArray();
        isVisited = new boolean[number.length];
        arr = new char[number.length];

        primeNum((int) Math.pow(10, numbers.length() + 1));

        for (int i = 1; i <= numbers.length(); i++) {
            makeNumber(i, 0);
        }
        return count;
    }

    static char[] number;
    static boolean[] pn;

    static void primeNum(int k) {
        pn = new boolean[k + 1];
        Arrays.fill(pn, true);
        pn[0] = false;
        pn[1] = false;

        for (int i = 2; i * i < k + 1; i++) {
            for (int j = i * i; j < k + 1; j += i) {
                pn[j] = false;
            }
        }
    }

    static boolean[] isVisited;
    static char[] arr;
    static int count;

    static void makeNumber(int length, int depth) {
        if (depth == length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(arr[i]);
            }
            if (pn[Integer.parseInt(sb.toString())]) {
                pn[Integer.parseInt(sb.toString())] = false;
                count++;
            }
        }

        for (int i = 0; i < number.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                arr[depth] = number[i];
                makeNumber(length, depth + 1);
                isVisited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("17"));
    }
}
