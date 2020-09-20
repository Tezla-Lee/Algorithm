package b3052;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[42];
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            count[Integer.parseInt(br.readLine()) % 42]++;
        }
        br.close();
        for (int num : count) {
            if (num != 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
