package _2021_라AD.프로그래밍3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 비선점 우선순위 스케줄링 원리
 */

class Solution2 {
    private static int currTime;

    public int solution(int[][] ads) {
        List<AD> pq = new ArrayList<>();
        currTime = 0;

        for (int[] ad : ads) {
            pq.add(new AD(ad[0], ad[1]));
        }

        while (!pq.isEmpty()) {
            pq.sort(new Comparator<AD>() {
                @Override
                public int compare(AD o1, AD o2) {
                    if ((currTime - o1.startTime) * o1.lossPerSec > (currTime - o2.startTime) * o2.lossPerSec) {
                        return 1;
                    } else if ((currTime - o1.startTime) * o1.lossPerSec == (currTime - o2.startTime) * o2.lossPerSec) {
                        return o1.startTime - o2.startTime;
                    } else {
                        return -1;
                    }
                }
            });

            AD ad = pq.remove(0);

            if (currTime < ad.startTime) {
                currTime = ad.startTime;
            }

            System.out.println(ad);
            System.out.println((currTime - ad.startTime) * ad.lossPerSec);
            currTime += 5;
        }

        return 0;
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().solution(new int[][]{{1, 2}, {3, 1}, {5, 3}}));
//        System.out.println(new Solution().solution(new int[][]{{1, 3}, {3, 2}, {5, 4}}));
//        System.out.println(new Solution().solution(new int[][]{{0, 3}, {5, 4}}));
        System.out.println(new Solution2().solution(new int[][]{{0, 1}, {0, 2}, {6, 3}, {8, 4}}));
//        System.out.println(new Solution().solution(new int[][]{{5, 2}, {2, 2}, {6, 3}, {9, 2}}));
    }

    private static class AD implements Comparable<AD> {
        int startTime;
        int lossPerSec;

        public AD(int startTime, int lossPerSec) {
            this.startTime = startTime;
            this.lossPerSec = lossPerSec;
        }

        @Override
        public String toString() {
            return "AD{" +
                    "startTime=" + startTime +
                    ", lossPerSec=" + lossPerSec +
                    '}';
        }

        @Override
        public int compareTo(AD o) {
            if ((currTime - o.startTime) * o.lossPerSec > (currTime - this.startTime) * this.lossPerSec) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}