package b8958;

import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int[] score;
        for (int i = 0; i < num; i++) {
            String temp = br.readLine();
            score = new int[temp.length()];
            int sum = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == 'O') {
                    if (j == 0) {
                        score[j] = 1;
                    } else {
                        score[j] = score[j - 1] + 1;
                    }
                }
                sum += score[j];
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}
