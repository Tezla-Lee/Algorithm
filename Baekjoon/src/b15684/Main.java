package b15684;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int[][] ladders = new int[h + 2][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            ladders[a][b] = 1;
            ladders[a][b + 1] = -1;
        }

        int num = 0;
        while (min == -1) {
            setLadders(ladders, 1, 1, num++, 0);
            if (num == 4) {
                break;
            }
        }
        System.out.println(min);
    }

    static int n;
    static int m;
    static int h;
    static int min = -1;

    static void setLadders(int[][] ladders, int a, int b, int addLaddersNum, int count) {

        if (addLaddersNum == count) {
            if (isPossible(ladders)) {
                min = count;
            }
            return;
        }

        for (int i = a; i < h + 1; i++) {
            for (int j = b; j < n; j++) {
                if (ladders[i][j] == 0 && ladders[i][j + 1] == 0) {
                    ladders[i][j] = 1;
                    ladders[i][j + 1] = -1;
                    setLadders(ladders, i, j + 2, addLaddersNum, count + 1);
                    ladders[i][j] = 0;
                    ladders[i][j + 1] = 0;
                }
            }
            b = 1;
        }
    }

    static boolean isPossible(int[][] arr) {
        for (int i = 1; i <= n; i++) {
            int row = 0;
            int col = i;

            for (int j = 0; j <= h; j++) {
                if (arr[row][col] == 1) {
                    col++;
                } else if (arr[row][col] == -1) {
                    col--;
                }
                row++;
            }
            if (col != i) {
                return false;
            }
        }
        return true;
    }
}