package b7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();
        int[] order = new int[n];
        Arrays.fill(order, 1);
        String[] info;
        for (int i = 0; i < n; i++) {
            info = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(info[0]), Integer.parseInt(info[1])});
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (list.get(i)[0] > list.get(j)[0] && list.get(i)[1] > list.get(j)[1]) {
                    order[j]++;
                } else if (list.get(i)[0] < list.get(j)[0] && list.get(i)[1] < list.get(j)[1]) {
                    order[i]++;
                }
            }
        }
        for (int i : order) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
