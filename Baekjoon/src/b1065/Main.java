package b1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    boolean hanNumber(int n) {
        return (n / 100) - (n / 10 % 10) == (n / 10 % 10) - n % 10;
    }

    int count(int n) {
        int answer = 0;
        if (n < 100) {
            return n;
        } else {
            answer += 99;
            for (int i = 100; i <= n; i++) {
                if (hanNumber(i)) {
                    answer++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(new Main().count(Integer.parseInt(br.readLine())));
    }
}