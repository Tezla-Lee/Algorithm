package number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int[] dr = {0, 0, 1, -1};
    private int[] dc = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    visitIsland(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void visitIsland(int row, int col, char[][] grid) {
        Queue<int[]> qu = new LinkedList<>();

        qu.add(new int[]{row, col});

        while (!qu.isEmpty()) {
            int[] curr = qu.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    qu.add(new int[]{nr, nc});
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }
}