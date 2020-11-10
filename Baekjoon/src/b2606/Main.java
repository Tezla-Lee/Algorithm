package b2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerNum = Integer.parseInt(br.readLine());
        int connectionNum = Integer.parseInt(br.readLine());
        int[][] network = new int[computerNum + 1][computerNum + 1];
        boolean[] isVisited = new boolean[computerNum + 1];
        for (int i = 0; i < connectionNum; i++) {
            String[] line = br.readLine().split(" ");
            network[Integer.parseInt(line[0])][Integer.parseInt(line[1])]++;
            network[Integer.parseInt(line[1])][Integer.parseInt(line[0])]++;
        }
        dfs(1, network, isVisited);
        System.out.println(count);
    }

    static int count = 0;

    public static void dfs(int start, int[][] network, boolean[] isVisited) {
        isVisited[start] = true;
        for (int i = 0; i < network.length; i++) {
            if (network[i][start] == 1 && !isVisited[i]) {
                dfs(i, network, isVisited);
                count++;
            }
        }
    }
}
