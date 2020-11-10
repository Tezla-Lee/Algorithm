package b2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[][] apt = new String[n][n];
        int num = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            apt[i] = br.readLine().split("");
        }
        for (int i = 0; i < apt.length; i++) {
            for (int j = 0; j < apt.length; j++) {
                if (apt[i][j].equals("1")) {
                    count = 0;
                    dfs(apt, i, j);
                    num++;
                    list.add(count);
                }
            }
        }
        System.out.println(num);
        Collections.sort(list);
        for (Integer integer : list) {
            sb.append(integer).append("\n");
        }
        System.out.println(sb);
//        for (int i = 0; i < apt.length; i++) {
//            for (int j = 0; j < apt.length; j++) {
//                System.out.print(apt[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count = 0;
//    static int dong = 2;

    public static void dfs(String[][] apt, int x, int y) {
        apt[x][y] = "0";
        count++;
        for (int i = 0; i < 4; i++) {
            if (x + dx[i] >= 0 && x + dx[i] < apt.length
                    && y + dy[i] >= 0 && y + dy[i] < apt.length) {
                if (apt[x + dx[i]][y + dy[i]].equals("1")) {
                    dfs(apt, x + dx[i], y + dy[i]);
                }
            }
        }
    }
}
