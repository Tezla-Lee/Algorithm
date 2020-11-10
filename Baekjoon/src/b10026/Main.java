package b10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] picture = new char[n][n];
        boolean[][] isVisited = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            picture[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    normal(picture, i, j, isVisited);
                    count++;
                }
            }
        }
        System.out.println(count);
        isVisited = new boolean[n][n];
        count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    rgBlindness(picture, i, j, isVisited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void normal(char[][] picture, int x, int y, boolean[][] isV) {
        isV[x][y] = true;
        int tempX, tempY;
        for (int i = 0; i < 4; i++) {
            tempX = x + dx[i];
            tempY = y + dy[i];
            if (tempX >= 0 && tempX < picture.length && tempY >= 0 && tempY < picture.length) {
                if (!isV[tempX][tempY] && picture[tempX][tempY] == picture[x][y]) {
                    normal(picture, tempX, tempY, isV);
                }
            }
        }
    }

    public static void rgBlindness(char[][] picture, int x, int y, boolean[][] isV) {
        isV[x][y] = true;
        int tempX, tempY;
        for (int i = 0; i < 4; i++) {
            tempX = x + dx[i];
            tempY = y + dy[i];
            if (tempX >= 0 && tempX < picture.length && tempY >= 0 && tempY < picture.length) {
                if (!isV[tempX][tempY]) {
                    if (picture[x][y] == 'R' || picture[x][y] == 'G') {
                        if (picture[tempX][tempY] == 'R' || picture[tempX][tempY] == 'G') {
                            rgBlindness(picture, tempX, tempY, isV);
                        }
                    } else {
                        if (picture[x][y] == picture[tempX][tempY]) {
                            rgBlindness(picture, tempX, tempY, isV);
                        }
                    }
                }
            }
        }
    }
}
