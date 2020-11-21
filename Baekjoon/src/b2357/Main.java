package b2357;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[][] arr = new long[n + 1][2];
        for (int i = 1; i < n + 1; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i;
        }

        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int) (o1[0] - o2[0]);
            }
        });

        long[][] arr2 = new long[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr2[i][0] = a;
            arr2[i][1] = b;
        }
        long[][] answer = new long[m][2];
        for (int i = 0; i < m; i++) {
            answer[i][0] = Integer.MAX_VALUE;
        }

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                if (count != m && answer[j][0] == Integer.MAX_VALUE && arr[i][1] <= arr2[j][1] && arr[i][1] >= arr2[j][0]) {
                    answer[j][0] = Math.min(answer[j][0], arr[i][0]);
                    count++;
                }
                if (arr[i][1] <= arr2[j][1] && arr[i][1] >= arr2[j][0]) {
                    answer[j][1] = Math.max(answer[j][1], arr[i][0]);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            sb.append(answer[i][0]).append(" ").append(answer[i][1]).append("\n");
        }
        System.out.println(sb);
    }
}