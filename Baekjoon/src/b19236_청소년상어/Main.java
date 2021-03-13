package b19236_청소년상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Fish[][] map = new Fish[4][4];
        List<Fish> fishes = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 4; j++) {
                Fish fish = new Fish(i, j, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                if (i == 0 && j == 0) {
                    fish.isLive = false;
                }
                map[i][j] = fish;
                fishes.add(fish);
            }
        }
        int answer = map[0][0].number;

        map[0][0] = new Fish(0, 0, 0, map[0][0].direction + 1);

//        moveFish(map, fishes, 0, 0, answer);
//
//        System.out.println(max);
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(1);
        list.add(10);
        System.out.println(list);
    }


    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};

    static void moveFish(Fish[][] map, List<Fish> fishes, int row, int col, int sum) {
        fishes.sort((a, b) -> a.number - b.number);
        System.out.println(fishes);

        Fish[][] map2 = new Fish[4][4];

        for (int i = 0; i < 4; i++) {
            map2[i] = map[i].clone();
        }

        for (Fish fish : fishes) {
            if (!fish.isLive) {
                continue;
            }

            int y = fish.row;
            int x = fish.col;


            for (int i = 0; i < 8; i++) {
                int ny = y + dy[fish.direction];
                int nx = x + dx[fish.direction];

                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && map2[ny][nx].number != 0 && map2[y][x].number != 0) {
                    Fish target = map2[ny][nx];

                    target.row = y;
                    target.col = x;
                    fish.row = ny;
                    fish.col = nx;

                    fishes.get(target.number - 1).row = y;
                    fishes.get(target.number - 1).row = x;

                    map2[ny][nx] = fish;
                    map2[y][x] = target;

                    break;
                } else {
                    fish.direction = (fish.direction + 1) % 8;
                }
            }
        }

        moveShark(map2, row, col, sum, fishes);
    }

    static int max = 0;

    static void moveShark(Fish[][] map, int row, int col, int sum, List<Fish> fishes) {
        System.out.println(row + " " + col + " " + sum);
        printMap(map);
        max = Math.max(max, sum);

        for (int i = 1; i <= 3; i++) {
            Fish shark = new Fish(row, col, 0, map[row][col].direction + 1);

            int ny = row + dy[shark.direction] * i;
            int nx = col + dx[shark.direction] * i;
//            System.out.println("move: " + dy[shark.direction] * i + " " + dx[shark.direction] * i);

            if (ny >= 0 && nx >= 0 && ny < 4 && nx < 4 && map[ny][nx].isLive) {
                Fish[][] map2 = new Fish[4][4];

                for (int j = 0; j < 4; j++) {
                    map2[j] = map[j].clone();
                }

                fishes.get(map[ny][nx].number - 1).isLive = false;
                fishes.get(map[ny][nx].number - 1).row = row;
                fishes.get(map[ny][nx].number - 1).col = col;

                map2[row][col] = map2[ny][nx];
                map2[row][col].isLive = false;
                map2[row][col].row = row;
                map2[row][col].col = col;

                shark.direction = map[ny][nx].direction;
                map2[ny][nx] = shark;
//                System.out.println("shark");
//                printMap(map2);
                moveFish(map2, fishes, ny, nx, sum + map[ny][nx].number);
                fishes.get(map[ny][nx].number - 1).isLive = true;
            }
        }
    }

    static void printMap(Fish[][] map) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (map[i][j] != null) {
                    System.out.printf("(%2d, %s)", map[i][j].number, map[i][j].isLive);
                }
            }
            System.out.println();
        }
    }
}

class Fish {
    int row;
    int col;
    int number;
    int direction;
    boolean isLive;

    public Fish(int row, int col, int number, int direction) {
        this.row = row;
        this.col = col;
        this.number = number;
        this.direction = direction - 1;
        this.isLive = true;
    }

    @Override
    public String toString() {
        return number + " " + isLive;
    }
}