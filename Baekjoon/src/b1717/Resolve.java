package b1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Resolve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        numbers = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numbers[i] = i;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            int temp1 = getParent(num1);
            int temp2 = getParent(num2);

            if (operation == 0) {
                if (temp1 != temp2) {
                    numbers[temp1] = temp2;
                }
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

    static int[] numbers;

    static int getParent(int k) {
        if (numbers[k] != k) {
            return getParent(numbers[k]);
        } else {
            return k;
        }
    }
}