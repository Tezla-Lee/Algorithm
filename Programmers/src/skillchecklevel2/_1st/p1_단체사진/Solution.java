package skillchecklevel2._1st.p1_단체사진;

import java.util.ArrayList;

class Solution {
    public int solution(int n, String[] data) {
        count = 0;
        data2 = data;
        bf(0);
        return count;
    }

    static char[] kakaoFriends = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] isVisited = new boolean[8];
    static char[] standInLine = new char[8];
    static ArrayList<Character> list = new ArrayList<>();
    static String[] data2;
    static int count;

    static void bf(int index) {
        if (index == 8) {
            boolean flag = true;
            for (String condition : data2) {
                if (!isPossible(condition)) {
                    return;
                }
            }
            count++;
            return;
        }
        for (int i = 0; i < 8; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                standInLine[index] = kakaoFriends[i];
                list.add(kakaoFriends[i]);
                bf(index + 1);
                isVisited[i] = false;
                list.remove(index);
            }
        }
    }


    static boolean isPossible(String s) {
        int i1 = list.indexOf(s.charAt(0));
        int i2 = list.indexOf(s.charAt(2));
        int want = Integer.parseInt(String.valueOf(s.charAt(4)));

        int actual = Math.abs(i1 - i2);
        char c = s.charAt(3);

        switch (c) {
            case '=':
                return want == actual - 1;
            case '>':
                return want < actual - 1;
            default:
                return want > actual - 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solution(2, new String[]{"N~F=0", "R~T>2"}));
        System.out.println(new Solution().solution(2, new String[]{"M~C<2", "C~M>1"}));
    }
}