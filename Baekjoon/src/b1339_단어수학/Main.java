package b1339_단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Alphabet> alphabets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        initAlphabets();

        while (n-- > 0) {
            addTheNumberOfAlphabet(br.readLine());
        }

        System.out.println(getMaxSum());
    }

    static void addTheNumberOfAlphabet(String string) {
        char[] chars = string.toCharArray();

        int index = string.length() - 1; // 지수

        for (char c : chars) {
            Alphabet alphabet = alphabets.get(c - 'A');

            alphabet.count += Math.pow(10, index--);
        }
    }

    static void initAlphabets() {
        alphabets = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            alphabets.add(new Alphabet((char) ('A' + i), 0));
        }
    }

    static int getMaxSum() {
        alphabets.sort((a, b) -> b.count - a.count);

        int sum = 0;
        int num = 9;

        for (Alphabet alphabet : alphabets) {
            sum += alphabet.count * num--;
        }

        return sum;
    }

    static private class Alphabet {
        char alphabet;
        int count;

        public Alphabet(char alphabet, int count) {
            this.alphabet = alphabet;
            this.count = count;
        }
    }
}
