package b1339_단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main2 {
    private static Integer[] alphabetCount;

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
            alphabetCount[c - 'A'] += (int) Math.pow(10, index--);
        }
    }

    static void initAlphabetCount() {
        alphabetCount = new Integer[26];

        Arrays.fill(alphabetCount, 0);
    }

    static int getMaxSum() {
        int sum = 0;
        int number = 9;

        Arrays.sort(alphabetCount, Collections.reverseOrder());

        for (int i = 0; i < 10; i++) {
            sum += alphabetCount[i] * number--;
        }

        return sum;
    }
}
