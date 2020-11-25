package b14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[][] s;
    static Stack<Integer> team1 = new Stack<>();
    static Stack<Integer> team2 = new Stack<>();
    static int[] players = new int[2];
    static boolean[] isChecked;
    static boolean[] isCheckedTeam1;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        s = new int[n][n];
//        team1 = new int[n / 2];
//        team2 = new int[n / 2];
        isChecked = new boolean[n];
        isCheckedTeam1 = new boolean[n / 2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        team(0, n, 0);
        System.out.println(min);
    }

    static int t1;
    static int min = Integer.MAX_VALUE;

    static void team(int num, int n, int index) {
        if (num == n / 2) {
            for (int i = 1; i <= n; i++) {
                if (!team1.contains(i)) {
                    team2.add(i);
                }
            }
            int score1;
            int score2;
            t1 = 0;
            score(0, team1, 0);
            score1 = t1;
            t1 = 0;
            score(0, team2, 0);
            score2 = t1;
            team2 = new Stack<>();
            min = Integer.min(score1 - score2 > 0 ? score1 - score2 : score2 - score1, min);
            return;
        }
        for (int i = index; i < n; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                team1.add(i + 1);
                team(num + 1, n, i + 1);
                if (min == 0) {
                    return;
                }
                team1.pop();
                isChecked[i] = false;
            }
        }
    }

    static void score(int num, Stack<Integer> arr, int index) {
        if (num == 2) {
            t1 += s[players[0] - 1][players[1] - 1] + s[players[1] - 1][players[0] - 1];
            return;
        }
        for (int i = index; i < n / 2; i++) {
            if (!isCheckedTeam1[i]) {
                isCheckedTeam1[i] = true;
                players[num] = arr.get(i);
                score(num + 1, arr, i);
                isCheckedTeam1[i] = false;
            }
        }
    }
}