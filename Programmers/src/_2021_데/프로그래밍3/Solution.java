package _2021_데.프로그래밍3;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Salesman> map = new HashMap<>();
        int[] money = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], new Salesman(enroll[i], map.getOrDefault(referral[i], null)));
        }

        for (int i = 0; i < seller.length; i++) {
            Salesman curr = map.get(seller[i]);

            int profit = amount[i] * 100;
            curr.money += profit;

            // 추천인들에게 10%씩 주는 과정
            while (true) {
                if (curr.money / 10 == 0) { // 이익 10% 1원 미만이면 종료
                    break;
                }

                curr.money -= profit / 10;

                if (curr.parent == null) { // 추천인 없으면 종료
                    break;
                }

                curr.parent.money += profit / 10;
                profit /= 10;

                curr = curr.parent;
            }
        }

        for (int i = 0; i < enroll.length; i++) {
            money[i] = map.get(enroll[i]).money;
        }

        return money;
    }
}

class Salesman {
    String name;
    Salesman parent;
    int money = 0;

    public Salesman(String name, Salesman parent) {
        this.name = name;
        this.parent = parent;
    }
}