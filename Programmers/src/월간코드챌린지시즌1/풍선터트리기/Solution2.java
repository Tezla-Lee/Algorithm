package 월간코드챌린지시즌1.풍선터트리기;

class Solution2 {
    public int solution(int[] a) {
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            if (!available(a, i)) {
                answer++;
            }
        }

        return answer;
    }

    static boolean available(int[] a, int index) {
        boolean left = false;
        boolean right = false;

        for (int i = 0; i < index; i++) {
            if (a[i] < a[index]) {
                left = true;
                break;
            }
        }

        for (int i = index + 1; i < a.length; i++) {
            if (a[i] < a[index]) {
                right = true;
                break;
            }
        }

        return left && right;
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().solution(new int[]{9, -1, -5}));
        System.out.println(new Solution2().solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }
}