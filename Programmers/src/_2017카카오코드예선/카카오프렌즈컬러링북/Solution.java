package _2017카카오코드예선.카카오프렌즈컬러링북;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 */
public class Solution {
    static boolean[][] isGone;

    public int[] solution(int m, int n, int[][] picture) {
        isGone = new boolean[m][n];
        ArrayList<Integer> info = new ArrayList<>();
        int[] answer = new int[2];
        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isGone[i][j] && picture[i][j] != 0) {
                    size = 0;
                    size = dfs(i, j, picture);
                    info.add(size);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }
        answer[0] = info.size();
        answer[1] = maxSize;
        return answer;
    }

    public static int size = 0;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int dfs(int x, int y, int[][] picture) {
        size++;
        isGone[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int temp_x = x + dx[i];
            int temp_y = y + dy[i];
            if (temp_x >= 0 && temp_x <= picture.length - 1 && temp_y >= 0 && temp_y <= picture[0].length - 1) {
                if (!isGone[temp_x][temp_y] && picture[temp_x][temp_y] == picture[x][y]) {
                    dfs(temp_x, temp_y, picture);
                }
            }
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }
}