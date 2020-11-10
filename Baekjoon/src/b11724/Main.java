package b11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);
        int count = 0;
        boolean[] isVisited = new boolean[n + 1];
        boolean[][] network = new boolean[n + 1][n + 1];
        String[] uv;
        for (int i = 0; i < m; i++) {
            uv = br.readLine().split(" ");
            network[Integer.parseInt(uv[0])][Integer.parseInt(uv[1])] = true;
            network[Integer.parseInt(uv[1])][Integer.parseInt(uv[0])] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            if (!isVisited[i]) {
                dfs(network, isVisited, i);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(boolean[][] network, boolean[] isV, int start) {
        isV[start] = true;
        for (int i = 0; i < network.length; i++) {
            if (network[start][i] && !isV[i]) {
                dfs(network, isV, i);
            }
        }
    }
}
