package b10818;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        StringTokenizer token = new StringTokenizer(br.readLine(), " ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (token.hasMoreTokens()) {
            int number = Integer.parseInt(token.nextToken());
            max = Math.max(number, max);
            min = Math.min(number, min);
        }
        bw.write(min + " " + max);
        bw.flush();
        bw.close();
    }
}
