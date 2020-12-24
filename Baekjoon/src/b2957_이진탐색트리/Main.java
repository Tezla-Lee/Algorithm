package b2957_이진탐색트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] depth = new int[n + 2];
        depth[0] = -1;
        depth[n + 1] = -1;
        long count = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        set.add(n + 1);
        for (int i = 0; i < n; i++) {
            int value = Integer.parseInt(br.readLine());
            set.add(value);
            depth[value] = Math.max(depth[set.lower(value)], depth[set.higher(value)]) + 1;
            count += depth[value];
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}