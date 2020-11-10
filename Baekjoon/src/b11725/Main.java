package b11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
//        int[][] v = new int[n + 1][n + 1];
        boolean[] isVisited = new boolean[n + 1];
        isVisited[0] = true;
        arr = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            String[] nodes = br.readLine().split(" ");
//            int node1 = Integer.parseInt(nodes[0]);
//            int node2 = Integer.parseInt(nodes[1]);
//            v[Integer.parseInt(nodes[0])][Integer.parseInt(nodes[1])] = 1;
//            v[Integer.parseInt(nodes[1])][Integer.parseInt(nodes[0])] = 1;
            list[Integer.parseInt(nodes[0])].add(Integer.parseInt(nodes[1]));
            list[Integer.parseInt(nodes[1])].add(Integer.parseInt(nodes[0]));
//            list[node1].add(node2);
//            list[node2].add(node1);
        }

        dfs(isVisited, 1);

        for (int i = 2; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
//            System.out.println(arr[i]);
        }
        System.out.println(sb);
    }

    public static int[] arr;
    static List<Integer>[] list;

    public static void dfs(boolean[] isV, int start) {
        isV[start] = true;
        for (int i : list[start]) {
            if (!isV[i]) {
                arr[i] = start;
                dfs(isV, i);
            }
        }
//        for (int i = 0; i < isV.length; i++) {
//            if (!isV[i] && v[start][i] == 1) {
//                arr[i] = start;
//                dfs(v, isV, i);
//            }
//        }
    }
}