package b2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m;
        int temp;
        boolean check = false;
        for (int i = 1; i < n; i++) {
            m = i;
            temp = i;
            while (true) {
                m += temp % 10;
                temp /= 10;
                if (temp == 0) {
                    break;
                }
            }
            if (m == n) {
                System.out.println(i);
                check = true;
                break;
            }
        }
        if (!check) {
            System.out.println(0);
        }
    }
}
