package 월간코드챌린지시즌1.풍선터트리기;

class Solution2 {
    public int solution(int[] a) {
        int answer = 0;

        leftDP = new int[a.length];
        rightDP = new int[a.length];

        solve(a);

        for (int i = 0; i < a.length; i++) {
            boolean left = false;
            boolean right = false;

            if (i > 0 && leftDP[i - 1] < a[i]) {
                left = true;
            }

            if (i < a.length - 1 && rightDP[i + 1] < a[i]) {
                right = true;
            }

            if (!(left && right)) {
                answer++;
            }
        }

        return answer;
    }

    static int[] leftDP;
    static int[] rightDP;

    static void solve(int[] a) {
        leftDP[0] = a[0];
        rightDP[a.length - 1] = a[a.length - 1];

        for (int i = 1; i < a.length; i++) {
            leftDP[i] = Math.min(a[i], leftDP[i - 1]);
        }

        for (int i = a.length - 2; i >= 0; i--) {
            rightDP[i] = Math.min(rightDP[i + 1], a[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().solution(new int[]{9, -1, -5}));
        System.out.println(new Solution2().solution(new int[]{-16, 27, 65, -2, 58, -92, -71, -68, -61, -33}));
    }
}