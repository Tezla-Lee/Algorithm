package b1789_수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());
        long ans = (long) Math.sqrt(s * 2);

        if (ans * (ans + 1) / 2 > s) {
            System.out.println(ans - 1);
        } else {
            System.out.println(ans);
        }
    }
}
