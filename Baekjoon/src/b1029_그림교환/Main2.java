package b1029_그림교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main2 {
    private static int n;
    private static int maxCount;
    private static boolean[] isBought;
    private static List<List<SellInfo>> lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        lists = new ArrayList<>();
        maxCount = 0;
        isBought = new boolean[n + 1];
        isBought[1] = true;

        for (int i = 0; i < n + 1; i++) {
            lists.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            char[] prices = br.readLine().toCharArray();

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                lists.get(i + 1).add(new SellInfo(Integer.parseInt(String.valueOf(prices[j])), j + 1));
            }
        }
        System.out.println(getMaxCount(new SellInfo(0, 1), 1));
    }

    private static int getMaxCount(SellInfo sellInfo, int depth) {
        maxCount = Math.max(maxCount, depth);

        for (SellInfo info : lists.get(sellInfo.buyer)) {
            if (!isBought[info.buyer] && info.price >= sellInfo.price) {
                isBought[info.buyer] = true;
                getMaxCount(info, depth + 1);
                isBought[info.buyer] = false;
            }
        }

        return maxCount;
    }

    private static class SellInfo {
        int price;
        int buyer;

        public SellInfo(int price, int buyer) {
            this.price = price;
            this.buyer = buyer;
        }
    }
}
