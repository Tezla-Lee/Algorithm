package b2775;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int k;
        int n;
        int caseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int temp = 0;
            for (int j = 0; j < n; j++) {
                arr[j] = j + 1;
            }
            for (int j = 0; j < k; j++) {
                temp = 0;
                for (int l = 0; l < n; l++) {
                    temp += arr[l];
                    arr[l] = temp;
                }
            }
            bw.write(temp + "\n");
        }
        bw.flush();
        bw.close();
    }
}
