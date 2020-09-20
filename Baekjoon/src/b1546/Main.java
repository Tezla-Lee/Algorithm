package b1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] scores = br.readLine().split(" ");
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < scores.length; i++) {
            int score = Integer.parseInt(scores[i]);
            sum += score;
            max = Math.max(max, score);
        }
        System.out.println((float) sum / scores.length / max * 100);
    }
}
