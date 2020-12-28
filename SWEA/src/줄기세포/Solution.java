package 줄기세포;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int num = 1;
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][][] arr = new int[n][m][4];
            Queue<Cell> queue = new LinkedList<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < m; l++) {
                    int lifeForce = Integer.parseInt(st.nextToken());
                    if (lifeForce != 0) {
                        arr[j][l][0] = lifeForce;
                        arr[j][l][1] = 2;
                        arr[j][l][2] = lifeForce;
                        // 패딩까지 생각해서 k/2 더함
                        queue.add(new Cell(j + k / 2, l + k / 2));
                    }
                }
            }

            // 줄기 세포가 번식할 공간을 위해 padding
            arr = padding(arr, k);

            sb.append("#").append(num++).append(" ").append(bfs(queue, arr, 0, k)).append("\n");

        }
        System.out.println(sb);
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static StringBuilder sb = new StringBuilder();

    static int bfs(Queue<Cell> queue, int[][][] arr, int time, int end) {
        if (time == end) {
            return queue.size();
        }

        Queue<Cell> queue1 = new LinkedList<>();

        while (!queue.isEmpty()) {

            Cell cell = queue.poll();

            int lifeForce = arr[cell.row][cell.col][0];

            // 활성 상태면 번식
            if (arr[cell.row][cell.col][1] == 1) {
                if (arr[cell.row][cell.col][2] > 0) {
                    arr[cell.row][cell.col][2]--;
                    // 남은 시간 0 되면 죽음
                    if (arr[cell.row][cell.col][2] == 0) {
                        arr[cell.row][cell.col][1] = 0;
                        // 아니면 다시 큐에 추가
                    } else {
                        queue1.add(cell);
                    }
                }

                for (int i = 0; i < 4; i++) {
                    int tempX = cell.row + dx[i];
                    int tempY = cell.col + dy[i];
                    // 빈칸
                    if (arr[tempX][tempY][0] == 0) {
                        queue1.add(new Cell(tempX, tempY));
                        arr[tempX][tempY][0] = lifeForce;
                        arr[tempX][tempY][1] = 2;
                        arr[tempX][tempY][2] = lifeForce;
                        arr[tempX][tempY][3] = time;
                        // 겹칠 때 더 큰 생명력으로
                    } else if (arr[tempX][tempY][0] < arr[cell.row][cell.col][0] && arr[tempX][tempY][1] == 2 && arr[tempX][tempY][3] == time) {
                        arr[tempX][tempY][0] = lifeForce;
                        arr[tempX][tempY][1] = 2;
                        arr[tempX][tempY][2] = lifeForce;
                    }
                }
            }

            // 비활성 상태면 남은 시간 -1
            if (arr[cell.row][cell.col][1] == 2) {
                queue1.add(cell);
                arr[cell.row][cell.col][2]--;
                // 0이 되면 활성 상태
                if (arr[cell.row][cell.col][2] == 0) {
                    arr[cell.row][cell.col][1] = 1;
                    // 남은 시간 원래대로
                    arr[cell.row][cell.col][2] = arr[cell.row][cell.col][0];
                }
            }
        }
//        System.out.println();
//        for (int j = 0; j < arr.length; j++) {
//            for (int l = 0; l < arr[0].length; l++) {
//                if (arr[j][l][0] == 0) {
//                    System.out.printf("%2c ", '.');
//                } else if (arr[j][l][1] > 0) {
//                    System.out.printf("[%d]", arr[j][l][0]);
//                } else {
//                    System.out.printf("%2d ", arr[j][l][0]);
//                }
//            }
//            System.out.println();
//        }

        return bfs(queue1, arr, time + 1, end);
    }

    static int[][][] padding(int[][][] arr, int time) {
        int[][][] newArr = new int[arr.length + time][arr[0].length + time][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArr[i + (time / 2)][j + (time / 2)] = arr[i][j];
            }
        }
        return newArr;
    }
}

class Cell {
    int row;
    int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}