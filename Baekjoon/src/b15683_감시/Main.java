package b15683_감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int min; // 사각지대
    static int[][] office;
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static List<CCTV> cctvs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        office = new int[n][m];
        cctvs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                office[i][j] = num;
                if (num > 0 && num < 6) {
                    cctvs.add(new CCTV(i, j, num));
                }
            }
        }

        min = n * m;
        if (!cctvs.isEmpty()) {
            setBestCCTV(0);
        } else {
            min = countBlindSpot();
        }

        System.out.println(min);
    }

    static void setBestCCTV(int num) {
        if (min == 0) {
            return;
        }

        if (num == cctvs.size()) {
            min = Math.min(countBlindSpot(), min);
            return;
        }

        CCTV cctv = cctvs.get(num);

        switch (cctv.number) {
            case 1:
                for (int i = 0; i < 4; i++) {
                    int[][] temp = saveOfficeState(); // 현재 상태 저장
                    setCCTV(i, cctv.row, cctv.col);
                    setBestCCTV(num + 1);
                    office = temp; // 이전 상태로
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    int[][] temp = saveOfficeState(); // 현재 상태 저장
                    setCCTV(i, cctv.row, cctv.col);
                    setCCTV(i + 2, cctv.row, cctv.col);
                    setBestCCTV(num + 1);
                    office = temp; // 이전 상태로
                }
                break;
            case 3:
                for (int i = 0; i < 4; i++) {
                    int[][] temp = saveOfficeState(); // 현재 상태 저장
                    setCCTV(i, cctv.row, cctv.col);
                    setCCTV((i + 1) % 4, cctv.row, cctv.col);
                    setBestCCTV(num + 1);
                    office = temp; // 이전 상태로
                }
                break;
            case 4:
                for (int i = 0; i < 4; i++) {
                    int[][] temp = saveOfficeState(); // 현재 상태 저장
                    setCCTV(i, cctv.row, cctv.col);
                    setCCTV((i + 1) % 4, cctv.row, cctv.col);
                    setCCTV((i + 2) % 4, cctv.row, cctv.col);
                    setBestCCTV(num + 1);
                    office = temp; // 이전 상태로
                }
                break;
            case 5:
                int[][] temp = saveOfficeState(); // 현재 상태 저장
                setCCTV(0, cctv.row, cctv.col);
                setCCTV(1, cctv.row, cctv.col);
                setCCTV(2, cctv.row, cctv.col);
                setCCTV(3, cctv.row, cctv.col);
                setBestCCTV(num + 1);
                office = temp; // 이전 상태로
                break;
        }
    }

    static void setCCTV(int dir, int row, int col) {
        int nextRow = row + dr[dir];
        int nextCol = col + dc[dir];

        while (nextRow >= 0 && nextCol >= 0 && nextRow < n && nextCol < m) {
            if (office[nextRow][nextCol] == 6) {
                break;
            }

            if (office[nextRow][nextCol] == 0) {
                office[nextRow][nextCol] = -1;
            }

            nextRow += dr[dir];
            nextCol += dc[dir];
        }
    }

    static int countBlindSpot() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (office[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    static int[][] saveOfficeState() {
        int[][] temp = new int[n][m];

        for (int i = 0; i < n; i++) {
            temp[i] = office[i].clone();
        }
        return temp;
    }

    static void printOffice() {
        System.out.println(min);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%3d", office[i][j]);
            }
            System.out.println();
        }
    }

    private static class CCTV {
        int row;
        int col;
        int number;

        public CCTV(int row, int col, int number) {
            this.row = row;
            this.col = col;
            this.number = number;
        }
    }
}

