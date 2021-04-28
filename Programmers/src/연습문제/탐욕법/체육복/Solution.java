package 연습문제.탐욕법.체육복;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> haveSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            haveSet.add(i);
        }

        for (int num : lost) {
            haveSet.remove(num);
        }

        for (int num : reserve) {
            if (!haveSet.contains(num)) {
                haveSet.add(num);
            } else {
                reserveSet.add(num);
            }
        }

        for (int num : reserveSet) {
            if (num != 1 && !haveSet.contains(num - 1)) {
                haveSet.add(num - 1);
            } else if (num != n){
                haveSet.add(num + 1);
            }
        }

        return haveSet.size();
    }
}