package _2021_DHK.task3;

class Solution {
    public int solution(String S) {
        if (S.length() < 3) {
            return 0;
        }

        char[] chars = S.toCharArray();

        int aCount = 0;

        for (char c : chars) {
            if (c == 'a') {
                aCount++;
            }
        }

        if (aCount == 0) {
            return combination(S.length() - 1, 2);
        } else if (aCount % 3 != 0) {
            return 0;
        }

        return getCountPossibleWay(chars, aCount);
    }

    private int getCountPossibleWay(char[] chars, int aCount) {
        int section1 = 1; // 첫 번째 구간 개수
        int section2 = 1; // 두 번째 구간 개수
        int count = 0; // a 개수 카운트

        for (char c : chars) {
            if (c == 'a') {
                count++;
                continue;
            }
            if (count == aCount / 3) {
                section1++;
            } else if (count == aCount * 2 / 3) {
                section2++;
            }
        }

        return section1 * section2;
    }

    private int combination(int n, int r) {
        int result = 1;

        for (int i = 0; i < r; i++) {
            result *= n--;
        }

        for (int i = 1; i <= r; i++) {
            result /= i;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution("babaa"));
        System.out.println(new Solution().solution("ababa"));
        System.out.println(new Solution().solution("aba"));
        System.out.println(new Solution().solution("bbbbb"));
        System.out.println(new Solution().solution("aababa"));
    }
}