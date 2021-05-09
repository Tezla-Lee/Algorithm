package _2021_라AD.프로그래밍3;

import java.util.Arrays;

/**
 * 비선점 우선순위 스케줄링 원리
 */

class Solution {
    private int minLossCost;
    private int currLossCost;
    private boolean[] isAd;
    private int[][] ads;

    public int solution(int[][] ads) {
        Arrays.sort(ads, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]); // 시작 시간 빠른순, 시작시간 같으면 손해비용 큰 순으로 정렬
        this.ads = ads;

        minLossCost = Integer.MAX_VALUE;
        currLossCost = 0;

        isAd = new boolean[25000];

        getMinTime(0);

        return minLossCost;
    }

    private void getMinTime(int index) {
        if (index == ads.length) {
            minLossCost = Math.min(minLossCost, currLossCost);
            return;
        }

        for (int i = ads[index][0]; i < 200; i++) {
            if (isAvailable(i)) {
                int lossCost = getLossCost(i, index);

                if (currLossCost + lossCost > minLossCost) {
                    break;
                }

                currLossCost += lossCost;
                System.out.println();
                System.out.println(i + " " + index + " " + lossCost);
                System.out.println("min: " + minLossCost);
                System.out.println("loss " + lossCost);
                System.out.println("curr: " + currLossCost);
                setAd(i);

                getMinTime(index + 1);

                unsetAd(i);
                currLossCost -= lossCost;
            }
        }
    }

    private void setAd(int startTime) {
        for (int i = startTime; i < startTime + 5; i++) {
            isAd[i] = true;
        }
    }

    private void unsetAd(int startTime) {
        for (int i = startTime; i < startTime + 5; i++) {
            isAd[i] = false;
        }
    }

    private int getLossCost(int startTime, int index) {
        return (startTime - ads[index][0]) * ads[index][1];
    }

    private boolean isAvailable(int startTime) {
        for (int i = startTime; i < startTime + 5; i++) {
            if (isAd[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().solution(new int[][]{{1, 2}, {3, 1}, {5, 3}}));
//        System.out.println(new Solution().solution(new int[][]{{1, 3}, {3, 2}, {5, 4}}));
//        System.out.println(new Solution().solution(new int[][]{{0, 3}, {5, 4}}));
        System.out.println(new Solution().solution(new int[][]{{0, 1}, {0, 2}, {6, 3}, {8, 4}}));
//        System.out.println(new Solution().solution(new int[][]{{5, 2}, {2, 2}, {6, 3}, {9, 2}}));
    }
}