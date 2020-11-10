package b1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] mnv = br.readLine().split(" ");
        int n = Integer.parseInt(mnv[0]);
        int m = Integer.parseInt(mnv[1]);
        int v = Integer.parseInt(mnv[2]);
        int[][] a = new int[n + 1][n + 1];
        String[] vv;
        boolean[] c = new boolean[n + 1];
        Arrays.fill(c, false);
        for (int i = 0; i < m; i++) {
            vv = br.readLine().split(" ");
            a[Integer.parseInt(vv[0])][Integer.parseInt(vv[1])] = 1;
            a[Integer.parseInt(vv[1])][Integer.parseInt(vv[0])] = 1;
        }
//        dfs(a, c, v);
//        sb.append(sb2).append("\n");
        sb.append(stackDfs(a, c, v).trim()).append("\n");
        c = new boolean[n + 1];
        Arrays.fill(c, false);
        sb.append(queueBfs(a, c, v).trim());
        System.out.println(sb);
    }

    public static String queueBfs(int[][] a, boolean[] c, int v) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(v);
        c[v] = true;
        while (!queue.isEmpty()) {
            int vv = queue.poll();
            sb.append(vv).append(" ");
            for (int i = 0; i < c.length; i++) {
                if (!c[i] && a[vv][i] == 1) {
                    queue.add(i);
                    c[i] = true;
                }
            }
        }
        return sb.toString();
    }

    static StringBuilder sb2 = new StringBuilder();

    public static String stackDfs(int[][] a, boolean[] c, int v) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        stack.push(v);
        while (!stack.isEmpty()) {
            int vv = stack.pop();
            if (!c[vv]) {
                sb.append(vv).append(" ");
                c[vv] = true;
            }
            for (int i = c.length - 1; i >= 0; i--) {
                if (!c[i] && a[vv][i] == 1) {
                    stack.push(i);
                    c[vv] = true;
                }
            }
        }
        return sb.toString();
    }

    public static void dfs(int[][] a, boolean[] c, int v) {
        c[v] = true;
        sb2.append(v).append(" ");
        for (int i = 0; i < a.length; i++) {
            if (a[v][i] == 1 && !c[i]) {
                dfs(a, c, i);
            }
        }
    }
}
