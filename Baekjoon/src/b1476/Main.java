package b1476;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int year = 0;
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        while (true) {
            if (year % 15 + 1 == e && year % 28 + 1 == s && year % 19 + 1 == m) {
                year++;
                break;
            }
                year++;
        }
        System.out.println(year);
    }
}
