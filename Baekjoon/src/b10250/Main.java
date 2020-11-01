package b10250;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int h;
        int n;
        int height;
        int ho;
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] hwn = br.readLine().split(" ");
            h = Integer.parseInt(hwn[0]);
            n = Integer.parseInt(hwn[2]);
            if (n % h == 0) {
                height = h;
            } else {
                height = n % h;
            }
            ho = (int) Math.ceil((float) n / h);
            bw.write(height * 100 + ho + "\n");
        }
        bw.flush();
        bw.close();
    }
}