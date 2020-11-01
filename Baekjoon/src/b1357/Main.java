package b1357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] xy = br.readLine().split(" ");
        System.out.println(rev(rev(Integer.parseInt(xy[0])) + rev(Integer.parseInt(xy[1]))));
    }

    public static int rev(int n) {
        StringBuilder sb = new StringBuilder(String.valueOf(n));

        return Integer.parseInt(sb.reverse().toString());
    }
}
