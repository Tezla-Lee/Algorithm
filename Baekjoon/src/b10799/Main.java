package b10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] pipe = br.readLine().toCharArray();
        int count = 0;
        int answer = 0;
        for (int i = 0; i < pipe.length; i++) {
            if (pipe[i] == '(') {
                count++;
                answer++;
                if (pipe[i + 1] == ')') {
                    answer += count - 1;
                    answer--;
                }
            }
            if (pipe[i] == ')') {
                count--;
            }
        }
        System.out.println(answer);
    }
}