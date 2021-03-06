package level1._소수찾기;

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;

        for (int i = 2; i * i < n + 1; i++) {
            if (!primes[i * i]) {
                continue;
            }

            for (int j = i * i; j < n + 1; j += i) {
                primes[j] = false;
            }
        }

        for (boolean prime : primes) {
            if (prime) {
                answer++;
            }
        }

        return answer;
    }
}