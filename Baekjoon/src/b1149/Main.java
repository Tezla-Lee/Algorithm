package b1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        House[] dp = new House[n + 1];
        dp[0] = new House(-1, 0);
        for (int i = 1; i < n + 1; i++) {
            String[] price = br.readLine().split(" ");
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < 3; j++) {
                if (j == dp[i - 1].colorNumber) {
                    continue;
                }
                if (min > Integer.parseInt(price[j])) {
                    min = Integer.parseInt(price[j]);
                    index = j;
                }
            }
            dp[i] = new House(index, dp[i - 1].price + min);
        }
        System.out.println(dp[n].price);
    }
}

class House {
    int colorNumber;
    int price;

    public House(int colorNumber, int price) {
        this.colorNumber = colorNumber;
        this.price = price;
    }
}