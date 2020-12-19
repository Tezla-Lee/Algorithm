package b2357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int[] arr = Arrays.copyOfRange(numbers, start, end + 1);
            Arrays.sort(arr);
            sb.append(arr[0]).append(" ").append(arr[end - start]).append("\n");
        }
        System.out.println(sb);
    }
}