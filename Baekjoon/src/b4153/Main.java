package b4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int line1;
        int line2;
        int line3;
        int max;
        while (true) {
            st = new StringTokenizer(br.readLine());
            line1 = Integer.parseInt(st.nextToken());
            line2 = Integer.parseInt(st.nextToken());
            line3 = Integer.parseInt(st.nextToken());
            if (line1 + line2 + line3 == 0) {
                break;
            }
            max = Math.max(line3, Math.max(line1, line2));
            if (line1 * line1 + line2 * line2 + line3 * line3 == 2 * max * max) {
                sb.append("right").append("\n");
            } else {
                sb.append("wrong").append("\n");
            }
        }
        System.out.println(sb);
    }
}
