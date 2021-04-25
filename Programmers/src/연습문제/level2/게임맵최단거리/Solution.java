package 연습문제.level2.게임맵최단거리;

import java.util.*;

class Solution {
    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};

    public int solution(int[][] maps) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        Queue<int[]> qu = new LinkedList<>();

        qu.offer(new int[]{0,0});
        isVisited[0][0] = true;

        while(!qu.isEmpty()) {
            int[] curr = qu.poll();

            for(int i = 0; i < 4; i++) {
                int nr = curr[0] + dx[i];
                int nc = curr[1] + dy[i];

                if (nr >= 0 && nc >= 0 && nr < maps.length && nc < maps[0].length && maps[nr][nc] == 1 && !isVisited[nr][nc]) {
                    isVisited[nr][nc] = true;
                    qu.offer(new int[]{nr, nc});
                    maps[nr][nc] = maps[curr[0]][curr[1]] + 1;

                    if (nr == maps.length - 1 && nc == maps[0].length - 1) {
                        return maps[nr][nc];
                    }
                }
            }
        }

        return -1;
    }
}