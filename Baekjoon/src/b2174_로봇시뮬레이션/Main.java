package b2174_로봇시뮬레이션;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static final int N = 0;
    static final int E = 1;
    static final int S = 2;
    static final int W = 3;

    static int a;
    static int b;

    static int[][] board;
    static Map<Integer, Robot> robotMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        board = new int[a + 1][b + 1];

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        robotMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();
            int dir = 0;

            switch (direction) {
                case "N":
                    dir = N;
                    break;
                case "E":
                    dir = E;
                    break;
                case "S":
                    dir = S;
                    break;
                case "W":
                    dir = W;
                    break;
            }

            board[x][y] = i + 1;
            robotMap.put(i + 1, new Robot(x, y, i + 1, dir));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int robotNum = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            if (!move(robotMap.get(robotNum), command, count)) {
                return;
            }
        }
        System.out.println("OK");
        br.close();
    }

    //                 N  E  S   W
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean move(Robot robot, String command, int count) {
        for (int i = 0; i < count; i++) {
            if (command.equals("R")) {
                robot.direction++;
                robot.direction %= 4;
            } else if (command.equals("L")) {
                robot.direction--;
                if (robot.direction < 0) {
                    robot.direction += 4;
                }
            } else if (command.equals("F")) {
                board[robot.x][robot.y] = 0;
                robot.x += dx[robot.direction];
                robot.y += dy[robot.direction];

                if (robot.x > a || robot.y > b || robot.x < 1 || robot.y < 1) {
                    System.out.println("Robot " + robot.number + " crashes into the wall");
                    return false;
                } else if (board[robot.x][robot.y] != 0) {
                    System.out.println("Robot " + robot.number + " crashes into robot " + board[robot.x][robot.y]);
                    return false;
                } else {
                    board[robot.x][robot.y] = robot.number;
                }
            }
        }
        return true;
    }
}


class Robot {
    int x;
    int y;
    int number;
    int direction;

    public Robot(int x, int y, int number, int direction) {
        this.x = x;
        this.y = y;
        this.number = number;
        this.direction = direction;
    }
}