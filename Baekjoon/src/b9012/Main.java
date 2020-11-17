package b9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int count = 0;
            boolean flag = false;
            char[] parenthesis = br.readLine().toCharArray();
            for (char c : parenthesis) {
                if (c == '(') {
                    count++;
                } else {
                    count--;
                }
                if (count < 0) {
                    sb.append("NO" + "\n");
                    flag = true;
                    break;
                }
            }
            if (count == 0) {
                sb.append("YES" + "\n");
            } else {
                if (!flag) {
                    sb.append("NO" + "\n");
                }
            }
        }
        System.out.println(sb);
    }
}