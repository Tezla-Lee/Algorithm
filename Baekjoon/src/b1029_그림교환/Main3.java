package b1029_그림교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main3 {
    private static int n;
    private static boolean[] isBought;
    private static List<List<Seller>> lists;
    private static int dp[][][];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        lists = new ArrayList<>();
        isBought = new boolean[n + 1];
        isBought[1] = true;
        dp = new int[1 << 15][n + 1][n + 1];

        for (int i = 0; i < n + 1; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            char[] prices = br.readLine().toCharArray();

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                lists.get(i + 1).add(new Seller(Integer.parseInt(String.valueOf(prices[j])), j + 1));
            }
        }

        System.out.println(getMaxCount(new Seller(0, 1), 1, 1));
    }

    private static int getMaxCount(Seller prevSeller, int history, int count) {
        int maxCount = count;

        for (Seller seller : lists.get(prevSeller.buyer)) {
            int buyers = history | (1 << (seller.buyer - 1));

            if (history < buyers && prevSeller.price <= seller.price && dp[buyers][prevSeller.buyer][seller.buyer] < count + 1) {
                dp[buyers][prevSeller.buyer][seller.buyer] = getMaxCount(seller, buyers, count + 1);
                maxCount = Math.max(maxCount, dp[buyers][prevSeller.buyer][seller.buyer]);
            }
        }
        return maxCount;
    }

    private static class Seller {
        int price;
        int buyer;

        public Seller(int price, int buyer) {
            this.price = price;
            this.buyer = buyer;
        }
    }
}
