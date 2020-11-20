package b2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int[] smallInBig = new int[input.length];
        int multiple = 1;
        int small = 0;
        int big = 0;
        boolean flag = false;
        int answer = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                multiple *= 2;
                small++;
            } else if (input[i] == '[') {
                multiple *= 3;
                big++;
                smallInBig[small]++;
            } else if (input[i] == ')') {
                if (i > 0 && input[i - 1] == '(') {
                    answer += multiple;
                }
                if (smallInBig[small] != 0) {
                    flag = true;
                    break;
                }
                small--;
                if (small < 0) {
                    flag = true;
                    break;
                }
                multiple /= 2;
            } else if (input[i] == ']') {
                if (i > 0 && input[i - 1] == '[') {
                    answer += multiple;
                }
                multiple /= 3;
                smallInBig[small]--;
                big--;
                if (big < 0 || smallInBig[small] < 0) {
                    flag = true;
                    break;
                }
            }
        }
        if (small != 0 || big != 0) {
            flag = true;
        }
        if (flag) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}
