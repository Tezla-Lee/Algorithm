package _2017_카카오코드예선._4단고음;

class Solution {
    static int count;

    public int solution(int n) {
        count = 0;

        // 1부터 높이기
//        raisePitch(1, 0, n);

        // n부터 낮추기
        lowerPitch(n, 0);

        return count;
    }

    // 1부터 음을 높여가서 찾기
    private void raisePitch(long pitch, int stack, int n) {
        if (pitch >= n) {
            if (pitch == n && stack == 0) {
                count++;
            }
            return;
        }

        raisePitch(pitch * 3, stack + 2, n);

        if (stack > 0) {
            raisePitch(pitch + 1, stack - 1, n);
        }

    }

    // 최종 음높이부터 낮춰가며 찾기
    private void lowerPitch(int pitch, int stack) {
        if (pitch <= 1) {
            if (pitch == 1 && stack == 0) {
                count++;
            }
            return;
        }

        if (pitch % 3 == 0 && stack >= 2) {
            lowerPitch(pitch / 3, stack - 2);
        }

        if ((pitch/ - 1) % 3 == 0 && Math.pow(3, (stack + 1) / 2) > pitch - 1) {
            return;
        }
        lowerPitch(pitch - 1, stack + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(15));
        System.out.println(new Solution().solution(24));
        System.out.println(new Solution().solution(41));
        System.out.println(new Solution().solution(2147483647));
    }
}