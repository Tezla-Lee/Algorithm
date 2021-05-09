package b14003_가장긴증가하는부분수열3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
    private static int n;
    private static int[] numbers;
    private static Progression[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        dp();
    }

    static void dp() {
        dp = new Progression[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = new Progression(numbers[i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[i] > numbers[i - 1]) {
                    dp[j][i] = dp[j][i - 1];
                    dp[j][i - 1].numbers.add(numbers[i]);
                    dp[j][i - 1].sum += numbers[i];
                } else {
                    dp[j][i] = dp[j][i - 1];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == null) {
                    System.out.print("    ");
                } else {
                    System.out.printf("%4d", dp[i][j].sum);
                }
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();

        for (int num : dp[0][n - 1].numbers) {
            sb.append(num).append(" ");
        }

        System.out.println(dp[0][n - 1].numbers.size());
        System.out.println(sb);
    }

//    private static Progression setProgression(int row, int col, int number) {
//        Progression progression = dp[row][col - 1];
//        ArrayList<Integer> temp = (ArrayList<Integer>) progression.numbers.clone();
//
//        temp.add(number);
//
//        return new Progression(progression.sum + number, temp);
//    }


    private static class Progression {
        long sum;
        ArrayList<Integer> numbers;

        public Progression(long sum, ArrayList<Integer> numbers) {
            this.sum = sum;
            this.numbers = numbers;
        }

        public Progression(int num) {
            this.sum = num;
            numbers = new ArrayList<>();
            numbers.add(num);
        }
    }
}
