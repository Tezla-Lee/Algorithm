package b1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        numbers = new int[n + 1];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = Integer.parseInt(st.nextToken());

            int temp1 = find(num2);
            int temp2 = find(num3);
            // 합집합
            if (num1 == 0) {
                if (temp1 != temp2) {
                    numbers[temp1] = temp2;
                }
                // 공집합
            } else {
                if (temp1 == temp2) {
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }

    static int find(int n) {
        if (numbers[n] == n) {
            return n;
        }
        return numbers[n] = find(numbers[n]);
    }
}
