package b14499_주사위굴리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int EAST = 1;
    private static final int WEST = 2;
    private static final int NORTH = 3;
    private static final int SOUTH = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(x, y, 0, 0, 0, 0, 0, 0);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            rollDice(dice, Integer.parseInt(st.nextToken()));
        }

        System.out.println(sb);
    }

    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    static void rollDice(Dice dice, int direction) {
        boolean ismoved = false;

        switch (direction) {
            case EAST:
                if (dice.x < map[0].length - 1) {
                    dice.setDice(dice.x + 1, dice.y, dice.left, dice.right, dice.down, dice.up, dice.front, dice.back);
                    ismoved = true;
                }
                break;
            case WEST:
                if (dice.x > 0) {
                    dice.setDice(dice.x - 1, dice.y, dice.right, dice.left, dice.up, dice.down, dice.front, dice.back);
                    ismoved = true;
                }
                break;
            case NORTH:
                if (dice.y > 0) {
                    dice.setDice(dice.x, dice.y - 1, dice.front, dice.back, dice.left, dice.right, dice.down, dice.up);
                    ismoved = true;
                }
                break;
            case SOUTH:
                if (dice.y < map.length - 1) {
                    dice.setDice(dice.x, dice.y + 1, dice.back, dice.front, dice.left, dice.right, dice.up, dice.down);
                    ismoved = true;
                }
                break;
        }

        if (ismoved) {
            if (map[dice.y][dice.x] == 0) {
                map[dice.y][dice.x] = dice.down;
            } else {
                dice.down = map[dice.y][dice.x];
                map[dice.y][dice.x] = 0;
            }
            sb.append(dice.up).append("\n");
        }
    }
}

class Dice {
    int x;
    int y;
    int up;
    int down;
    int left;
    int right;
    int front;
    int back;

    public void setDice(int x, int y, int up, int down, int left, int right, int front, int back) {
        this.x = x;
        this.y = y;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.front = front;
        this.back = back;
    }

    public Dice(int x, int y, int up, int down, int left, int right, int front, int back) {
        this.x = x;
        this.y = y;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.front = front;
        this.back = back;
    }
}