package b3020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] stalagmite = new int[n / 2];
        int[] stalactite = new int[n / 2];

        for (int i = 0; i < n / 2; i++) {
            stalagmite[i] = Integer.parseInt(br.readLine());
            stalactite[i] = Integer.parseInt(br.readLine());
        }

        int[] stalagmiteHeight = new int[h + 1]; // 석순
        int[] stalactiteHeight = new int[h + 1]; // 종유석

        // 석순, 종유석마다 높이 별로 몇개 씩 있는지 확인
        for (int i = 0; i < n / 2; i++) {
            stalagmiteHeight[stalagmite[i]]++;
            stalactiteHeight[stalactite[i]]++;
        }

        // 각 높이이상의 갯수를 확인할 수 있도록 만듦
        for (int i = 1; i < h; i++) {
            stalagmiteHeight[h - i - 1] += stalagmiteHeight[h - i];
            stalactiteHeight[h - i - 1] += stalactiteHeight[h - i];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 1; i <= h; i++) {
            int breakCount = stalagmiteHeight[i] + stalactiteHeight[h - i + 1];
            if (breakCount < min) {
                min = breakCount;
                count = 1;
            } else if (breakCount == min) {
                count++;
            }
        }
        System.out.println(min + " " + count);
    }
}