package _2021_가.프로그래밍2;

import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public boolean solution(int[] arr, int n) {
        Set<Integer> set = new HashSet<>(); // arr에 들어 있는 수 저장

        for (int num : arr) {
            set.add(num);
        }

        for (int num : arr) {
            if (n != num * 2 && set.contains(n - num)) { // num 과 더해서 n 이 되는 수가 있는지 확인
                return true;
            }
        }

        return false;
    }
}
