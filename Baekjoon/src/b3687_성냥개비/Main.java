package b3687_성냥개비;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] min = new long[n + 1];
            StringBuilder max = new StringBuilder();

            if (n < 8) {
                min = new long[8];
            }

            setUpMin(min);

            // min
            for (int i = 4; i < n + 1; i++) {
                if (i > 7) {
                    min[i] = Math.min(min[i], Long.parseLong('1' + String.valueOf(min[i - 2])));
                    min[i] = Math.min(min[i], Math.min(Long.parseLong('7' + String.valueOf(min[i - 3])), Long.parseLong(String.valueOf(min[i - 3]) + '7')));
                    min[i] = Math.min(min[i], Math.min(Long.parseLong('4' + String.valueOf(min[i - 4])), Long.parseLong(String.valueOf(min[i - 4]) + '4')));
                    min[i] = Math.min(min[i], Math.min(Long.parseLong('2' + String.valueOf(min[i - 5])), Long.parseLong(String.valueOf(min[i - 5]) + '2')));
                    min[i] = Math.min(min[i], Long.parseLong(String.valueOf(min[i - 6]) + '0'));
                    min[i] = Math.min(min[i], Long.parseLong(String.valueOf(min[i - 7]) + '8'));
                }
            }

            // max
            if (n % 2 == 1) {
                max.append("7");
            } else {
                max.append("1");
            }

            for (int i = 0; i < n / 2 - 1; i++) {
                max.append("1");
            }

            sb.append(min[n]).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }

    // min 초기세팅
    static void setUpMin(long[] min) {
        Arrays.fill(min, Long.MAX_VALUE / 100);

        min[2] = 1;
        min[3] = 7;
        min[4] = 4;
        min[5] = 2;
        min[6] = 6;
        min[7] = 8;
    }
}