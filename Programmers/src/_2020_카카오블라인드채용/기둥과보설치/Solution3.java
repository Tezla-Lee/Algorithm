package _2020_카카오블라인드채용.기둥과보설치;

public class Solution3 {
    static int[][] beam; // 보
    static int[][] column; // 기둥

    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};

        beam = new int[n + 1][n + 1];
        column = new int[n + 1][n + 1];

        for (int[] arr : build_frame) { // x y a b
            int x = arr[0];
            int y = arr[1];
            int a = arr[2];
            int b = arr[3];

            if (b == 1) { // 설치
                if (isPossibleInstallation(a, x, y)) {
                    install(a, x, y);
                }
            } else { // 파괴
                if (isPossibleDestruction(a, x, y)) {
                    destruct(a, x, y);
                }
            }
        }

        return answer;
    }

    // a : 0 -> 기둥, 1 -> 보
    // b : 0 -> 삭제, 1 -> 설치

    static boolean isPossibleInstallation(int structure, int x, int y) {
        if (structure == 0) { // 기둥
            return y == 0 || beam[x][y] > 0; // 바닥이거나 보 위
        } else { // 보
            if (column[x][y] > 0 || column[x + 1][y] > 0) { // 보 끝에 기둥이 있는 경우
                return true;
            } else {
                return beam[x][y] > 0 && beam[x + 1][y] > 0; // 양 끝에 보가 있는 경우
            }
        }
    }

    static boolean isPossibleDestruction(int structure, int x, int y) {
        if (structure == 0) { // 기둥

        } else { // 보

        }
        return true;
    }

    static void install(int structure, int x, int y) {
        if (structure == 0) { // 기둥
            column[x][y]++;
            column[x][y + 1]++;
        } else { // 보
            beam[x][y]++;
            beam[x + 1][y]++;
        }
    }

    static void destruct(int structure, int x, int y) {
        if (structure == 0) { // 기둥
            column[x][y]--;
            column[x][y + 1]--;
        } else { // 보
            beam[x][y]--;
            beam[x + 1][y]--;
        }
    }

    public static void main(String[] args) {
        new Solution3().solution(5, new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}});
        System.out.println();
        new Solution3().solution(5, new int[][]{{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}});
    }
}