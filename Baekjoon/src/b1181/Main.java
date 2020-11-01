package b1181;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];

        while (n-- != 0) {
            String s = br.readLine();
            strings[n] = s;
        }

        Arrays.sort(strings, (a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            }
            return a.length() - b.length();
        });

        String temp = "";

        for (String s : strings) {
            if (temp.equals(s)) {
                continue;
            }
            bw.write(s + "\n");
            temp = s;
        }
        bw.close();
    }
}
