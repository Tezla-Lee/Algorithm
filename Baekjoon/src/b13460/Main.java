package b13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }
        RedBlue start = new RedBlue();
        end = new RedBlue();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'B') {
                    start.blueX = j;
                    start.blueY = i;
                }
                if (board[i][j] == 'R') {
                    start.redX = j;
                    start.redY = i;
                }
                if (board[i][j] == 'O') {
                    end.redX = j;
                    end.redY = i;
                    end.blueX = j;
                    end.blueY = i;
                }
            }
        }
        Queue<RedBlue> queue = new LinkedList<>();
        queue.offer(start);
        bfs(0, queue);
    }

    static RedBlue end;
    static int n, m;
    static char[][] board;


    static void bfs(int depth, Queue<RedBlue> queue) {
        System.out.println(depth);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        if (depth > 10) {
            System.out.println(-1);
            return;
        }
        Queue<RedBlue> queue2 = new LinkedList<>();
        while (!queue.isEmpty()) {
            RedBlue temp = queue.poll();
            RedBlue temp2;
            if (temp.blueX == end.blueX && temp.blueY == end.blueY) {
                System.out.println(-1);
                return;
            }
            if (temp.redX == end.redX && temp.redY == end.redY) {
                System.out.println(depth);
                return;
            }
            temp2 = moveRight(temp);
            if (temp.redX != temp2.redX || temp.redY != temp2.redY || temp.blueX != temp2.blueX || temp.blueY != temp2.blueY) {
                queue2.offer(temp2);
            }
            temp2 = moveLeft(temp);
            if (temp.redX != temp2.redX || temp.redY != temp2.redY || temp.blueX != temp2.blueX || temp.blueY != temp2.blueY) {
                queue2.offer(temp2);
            }
            temp2 = moveUp(temp);
            if (temp.redX != temp2.redX || temp.redY != temp2.redY || temp.blueX != temp2.blueX || temp.blueY != temp2.blueY) {
                queue2.offer(temp2);
            }
            temp2 = moveDown(temp);
            if (temp.redX != temp2.redX || temp.redY != temp2.redY || temp.blueX != temp2.blueX || temp.blueY != temp2.blueY) {
                queue2.offer(temp2);
            }
            board[temp.redY][temp.redX] = '.';
            board[temp.blueY][temp.blueX] = '.';
        }
        bfs(depth + 1, queue2);
    }

    static RedBlue moveRight(RedBlue temp) {
        RedBlue temp2 = new RedBlue(temp.redX, temp.redY, temp.blueX, temp.blueY);
        board[temp2.redY][temp2.redX] = '.';
        board[temp2.blueY][temp2.blueX] = '.';
        while (true) {
            temp2.redX++;
            if (board[temp2.redY][temp2.redX] == 'O') {
                break;
            }
            if (board[temp2.redY][temp2.redX] != '.') {
                temp2.redX--;
                board[temp2.redY][temp2.redX] = 'R';
                break;
            }
        }
        while (true) {
            temp2.blueX++;
            if (board[temp2.blueY][temp2.blueX] == 'O') {
                break;
            }
            if (board[temp2.blueY][temp2.blueX] != '.') {
                temp2.blueX--;
                board[temp2.blueY][temp2.blueX] = 'B';
                break;
            }
        }
        return temp2;
    }

    static RedBlue moveLeft(RedBlue temp) {
        RedBlue temp2 = new RedBlue(temp.redX, temp.redY, temp.blueX, temp.blueY);
        board[temp2.redY][temp2.redX] = '.';
        board[temp2.blueY][temp2.blueX] = '.';
        while (true) {
            temp2.redX--;
            if (board[temp2.redY][temp2.redX] == 'O') {
                break;
            }
            if (board[temp2.redY][temp2.redX] != '.') {
                temp2.redX++;
                board[temp2.redY][temp2.redX] = 'R';
                break;
            }
        }
        while (true) {
            temp2.blueX--;
            if (board[temp2.blueY][temp2.blueX] == 'O') {
                break;
            }
            if (board[temp2.blueY][temp2.blueX] != '.') {
                temp2.blueX++;
                board[temp2.blueY][temp2.blueX] = 'B';
                break;
            }
        }
        return temp2;
    }

    static RedBlue moveUp(RedBlue temp) {
        RedBlue temp2 = new RedBlue(temp.redX, temp.redY, temp.blueX, temp.blueY);
        board[temp2.redY][temp2.redX] = '.';
        board[temp2.blueY][temp2.blueX] = '.';
        while (true) {
            temp2.redY++;
            if (board[temp2.redY][temp2.redX] == 'O') {
                break;
            }
            if (board[temp2.redY][temp2.redX] != '.') {
                temp2.redY--;
                board[temp2.redY][temp2.redX] = 'R';
                break;
            }
        }
        while (true) {
            temp2.blueY++;
            if (board[temp2.blueY][temp2.blueX] == 'O') {
                break;
            }
            if (board[temp2.blueY][temp2.blueX] != '.') {
                temp2.blueY--;
                board[temp2.blueY][temp2.blueX] = 'B';
                break;
            }
        }
        return temp2;
    }

    static RedBlue moveDown(RedBlue temp) {
        RedBlue temp2 = new RedBlue(temp.redX, temp.redY, temp.blueX, temp.blueY);
        board[temp.redY][temp.redX] = '.';
        board[temp.blueY][temp.blueX] = '.';
        while (true) {
            temp2.redY--;
            if (board[temp2.redY][temp2.redX] == 'O') {
                break;
            }
            if (board[temp2.redY][temp2.redX] != '.') {
                temp2.redY++;
                board[temp2.redY][temp2.redX] = 'R';
                break;
            }
        }
        while (true) {
            temp2.blueY--;
            if (board[temp2.blueY][temp2.blueX] == 'O') {
                break;
            }
            if (board[temp2.blueY][temp2.blueX] != '.') {
                temp2.blueY++;
                board[temp2.blueY][temp2.blueX] = 'B';
                break;
            }
        }
        return temp2;
    }
}

class RedBlue {
    int redX;
    int redY;
    int blueX;
    int blueY;

    public RedBlue() {
    }

    public RedBlue(int redX, int redY, int blueX, int blueY) {
        this.redX = redX;
        this.redY = redY;
        this.blueX = blueX;
        this.blueY = blueY;
    }

    @Override
    public String toString() {
        return "RedBlue{" +
                "redX=" + redX +
                ", redY=" + redY +
                ", blueX=" + blueX +
                ", blueY=" + blueY +
                '}';
    }
}