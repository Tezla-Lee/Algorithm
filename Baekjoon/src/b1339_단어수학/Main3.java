package b1339_단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3 {
    private static int[] alphabetCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        initAlphabetCount();

        while (n-- > 0) {
            addTheNumberOfAlphabet(br.readLine());
        }

        System.out.println(getMaxSum());
    }

    static void addTheNumberOfAlphabet(String string) {
        char[] chars = string.toCharArray();

        int index = string.length() - 1; // 지수

        for (char c : chars) {
            alphabetCount[c - 'A'] += Math.pow(10, index--);
        }
    }

    static void initAlphabetCount() {
        alphabetCount = new int[26];
    }

    static int getMaxSum() {
        int sum = 0;
        int number = 9;

        Arrays.sort(alphabetCount);

        for (int i = 25; i > 15; i--) {
            sum += alphabetCount[i] * number--;
        }

        return sum;
    }
}
