package b4344;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        int sum;
        int numberOfStudent;
        int average;
        int count;
        String[] scores;
        for (int i = 0; i < testCount; i++) {
            sum = 0;
            count = 0;
            scores = br.readLine().split(" ");
            numberOfStudent = Integer.parseInt(scores[0]);
            for (int j = 1; j < scores.length; j++) {
                sum += Integer.parseInt(scores[j]);
            }
            average = sum / numberOfStudent;
            for (int j = 1; j < scores.length; j++) {
                if (Integer.parseInt(scores[j]) > average) {
                    count++;
                }
            }
            System.out.printf("%.3f%%%n", (float) count / numberOfStudent * 100);
        }
    }
}