package b1011;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseNum = Integer.parseInt(br.readLine());
        int start;
        int end;
        int count;

        for (int i = 0; i < caseNum; i++) {
            String[] startEnd = br.readLine().split(" ");
            start = Integer.parseInt(startEnd[0]);
            end = Integer.parseInt(startEnd[1]);
            count = ((int) Math.sqrt(end - start)) * 2 - 1;

            if (count(count) == end - start) {
                bw.write(count + "\n");
            } else if (count(count) + (int) Math.sqrt(count(count)) >= end - start) {
                bw.write(count + 1 + "\n");
            } else if (count(count) + (int) Math.sqrt(count(count)) < end - start) {
                bw.write(count + 2 + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    public static int count(int k) {
        if (k % 2 == 0) {
            return k * (k + 2) / 4;
        } else {
            return ((k + 1) / 2) * ((k + 1) / 2);
        }
    }
}